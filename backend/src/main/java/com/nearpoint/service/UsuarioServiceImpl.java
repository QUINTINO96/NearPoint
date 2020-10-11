package com.nearpoint.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearpoint.beans.UsuarioDTO;
import com.nearpoint.model.Post;
import com.nearpoint.model.Usuario;
import com.nearpoint.repository.UsuarioCustomRepository;
import com.nearpoint.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	private UsuarioCustomRepository usucustom;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return this.usuarioRepository.findAll();
	}
	
	public List<Usuario> getUsuario(){
		return this.usucustom.getAll();
	}

	@Override
	public Optional<Usuario> getUsuarioById(Long usuarioId) {
		return this.usuarioRepository.findById(usuarioId);
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuarioDetails) {
		return this.usuarioRepository.save(usuarioDetails);
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
	}

    	@Override
	public List<Usuario> getAllInnerJoin() {
		return this.usuarioRepository.findAllInnerJoin();
	}
	
}
