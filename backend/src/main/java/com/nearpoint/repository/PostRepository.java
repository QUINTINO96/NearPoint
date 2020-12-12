package com.nearpoint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nearpoint.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	@Modifying
	@Query(value ="select p.id,p.titulo,p.foto_anuncio,p.descricao,p.id_usu from Post as p where p.id_usu = (:idUsu)",nativeQuery = true)
	
	List <Post> ListbyId(@Param("idUsu")Long idUsu);
	
}
