package com.nearpoint.controller;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nearpoint.beans.PostDTO;
import com.nearpoint.beans.UsuarioDTO;
import com.nearpoint.exception.ResourceNotFoundException;
import com.nearpoint.model.Post;
import com.nearpoint.model.Usuario;
import com.nearpoint.repository.UsuarioCustomRepository;
import com.nearpoint.repository.UsuarioRepository;
import com.nearpoint.service.UsuarioService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class UsuarioController {
	
	
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	UsuarioCustomRepository userCustom;
	UsuarioService usuarioService;
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios")
	public List<Usuario> getAlUsuarios(){
		return usuarioRepository.findAll();
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios/email/{email}")
	public List<Usuario> getListByEmail(@PathVariable(value = "email")String email){
		return usuarioRepository.findAll();
	}

    @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login/validade")
	public List<Usuario> getValidade(){
		return this.usuarioRepository.Validade();
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException{
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum usuario localizado :: " + usuarioId));
		return ResponseEntity.ok().body(usuario);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/cadastro")	
	public Usuario addUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioId,
			@Validated @RequestBody Usuario usuarioDetalhes) throws ResourceNotFoundException, UnsupportedEncodingException{
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar :: " +usuarioId + ":: não localizado"));
		
		usuario.setNome(usuarioDetalhes.getNome());
		usuario.setTelefone(usuarioDetalhes.getTelefone());
		usuario.setRua(usuarioDetalhes.getRua());
		usuario.setBairro(usuarioDetalhes.getBairro());
		usuario.setComplemento(usuarioDetalhes.getComplemento());
		usuario.setCEP(usuarioDetalhes.getCEP());
		usuario.setCidade(usuario.getCidade());
		usuario.setEstado(usuarioDetalhes.getEstado());
		usuario.setListPosts(usuarioDetalhes.getListPosts());
		usuario.setEmail(usuarioDetalhes.getEmail());
		usuario.setTelefone(usuarioDetalhes.getTelefone());
		usuario.setCpf(usuarioDetalhes.getCpf());
		usuario.setDataNascimento(usuarioDetalhes.getDataNascimento());
		usuario.setFotoPerfil(usuarioDetalhes.getFotoPerfil());
		usuario.setSenha(usuarioDetalhes.getSenha());
		usuario.setSobrenome(usuarioDetalhes.getSobrenome());
		usuario.setTipoUsuario(usuarioDetalhes.getTipoUsuario());
		final Usuario upUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(upUsuario);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/usuarios/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId)
		throws ResourceNotFoundException{
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe empresa para esse id :: "+usuarioId));
		usuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
	}
	

	public Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
		return usuario;
	}

}
