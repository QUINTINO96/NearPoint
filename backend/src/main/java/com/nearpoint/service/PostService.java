package com.nearpoint.service;

import java.util.List;
import java.util.Optional;

import com.nerpoint.model.Post;

public interface PostService {
	
	List<Post> getAllPosts();

	Optional<Post> getPostById(Long postId);

	Post createPost(Post post);	

	Post updatePost(Post postDetails);

	void deletePost(Post post);
	
	//List<Post>getAllPosts();
}
