package com.nearpoint.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nearpoint.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Modifying
	@Query(value = "SELECT id,senha,email  from usuarios",nativeQuery = true)	
	List<Usuario> Validade();

}

