package com.nearpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nerpoint.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	//@Query(value = "SELECT * FROM empregados u WHERE u.funcao = 3 ",
	//		nativeQuery = true )
	//List<Post> findAllProprietario();
	
}
