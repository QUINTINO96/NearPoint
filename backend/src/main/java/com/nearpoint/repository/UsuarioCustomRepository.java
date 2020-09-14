package com.nearpoint.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.nerpoint.model.Usuario;

@Repository
public class UsuarioCustomRepository {
	
	private final EntityManager usu;
	
	public UsuarioCustomRepository(EntityManager usu) {
		this.usu = usu;
	}
	
		public List<Usuario> getAll(){
		
		String query = "select E from empresas as E";
		
		TypedQuery<Usuario> q = usu.createQuery(query, Usuario.class);
		
		return q.getResultList();
		
	}
}
