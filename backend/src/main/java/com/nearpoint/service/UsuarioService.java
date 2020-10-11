package com.nearpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nearpoint.beans.UsuarioDTO;
import com.nearpoint.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> getAllUsuarios();

	Optional<Usuario> getUsuarioById(Long usuarioId);

	Usuario createUsuario(Usuario usuario);	

	Usuario updateUsuario(Usuario usuarioDetails);

	void deleteUsuario(Usuario usuario);
    
    List<Usuario> getAllInnerJoin();

}
