package com.nearpoint.repository;



import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nearpoint.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Modifying
	@Query("select u.id,u.email,u.senha from Usuario as u ")

	List<Usuario> Validade();
	

}

