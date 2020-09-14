package com.nearpoint.controller;

import java.io.Console;
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
import org.springframework.web.bind.annotation.RestController;

import com.nearpoint.DTO.PostDTO;
import com.nearpoint.DTO.UsuarioDTO;
import com.nearpoint.exception.ResourceNotFoundException;
import com.nearpoint.repository.UsuarioCustomRepository;
import com.nearpoint.repository.UsuarioRepository;
import com.nearpoint.service.UsuarioService;
import com.nerpoint.model.Post;
import com.nerpoint.model.Usuario;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	UsuarioCustomRepository userCustom;
	UsuarioService usuarioService;
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("usuarios")
	public List<Usuario> getAlUsuarios(){
		return usuarioRepository.findAll();
	}

    	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios/inner")
	public List<Usuario> findAllusuarios(){
		return usuarioRepository.findAllInnerJoin();
		
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
	@PostMapping("/usuario")
	public Usuario addUsuario(@Validated @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	/*@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/empresas/{id}")
	public Empresa addEmpresas(@Validated @RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}*/
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioId,
			@Validated @RequestBody Usuario usuarioDetalhes) throws ResourceNotFoundException{
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar :: " +usuarioId + ":: não localizado"));
		
		usuario.setNome(usuarioDetalhes.getNome());
		usuario.setTelefone(usuarioDetalhes.getTelefone());
		usuario.setEndereco(usuarioDetalhes.getEndereco());
		usuario.setListPosts(usuarioDetalhes.getListPosts());
		usuario.setEmailId(usuarioDetalhes.getEmailId());
		usuario.setTelefone(usuarioDetalhes.getTelefone());
		usuario.setCPF(usuarioDetalhes.getCPF());
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
