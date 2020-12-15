package com.nearpoint.repository;



import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nearpoint.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Modifying
	@Query("select u.id,u.email,u.senha from Usuario as u ")

	List<Usuario> Validade();
	
	@Modifying
	@Query(value ="select u.id, from Usuario as u where u.email = (:email)",nativeQuery = true)
	
	List<Usuario> ListByEmail(@Param("email")String email);
	

}

