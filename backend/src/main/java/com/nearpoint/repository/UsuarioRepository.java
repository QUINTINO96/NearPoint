package com.nearpoint.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nerpoint.model.Post;
import com.nerpoint.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Modifying@Query(value = "select emp.id, emp.nome_empresa, emp.cnpj_empresa, emp.endereco, emp.date_fundacao,\n" + 
			"emp.telefone, e.nome_completo, emp.empregado_id from empresas as emp\n" + 
			"inner join posts as e on e.id = emp.post_id",
			nativeQuery = true )
	List<Usuario> findAllInnerJoin();

}

