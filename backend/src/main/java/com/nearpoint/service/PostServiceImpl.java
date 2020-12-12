package com.nearpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nearpoint.model.Post;
import com.nearpoint.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getAllPosts() {
		return this.postRepository.findAll();
	}

	@Override
	public Optional<Post> getPostById(Long postId) {
		return this.postRepository.findById(postId);
	}

	@Override
	public Post createPost(Post post) {
		return this.postRepository.save(post);
	}

	@Override
	public Post updatePost(Post postDetails) {
		return this.postRepository.save(postDetails);
	}

	@Override
	public void deletePost(Post post) {
		this.postRepository.delete(post);
	}
	
	@Override
	public List<Post> getListById(Long idUsu){
		return this.postRepository.ListbyId(idUsu);
	}
}
