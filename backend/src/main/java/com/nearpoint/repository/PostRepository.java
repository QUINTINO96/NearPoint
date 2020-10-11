package com.nearpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nearpoint.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
}
