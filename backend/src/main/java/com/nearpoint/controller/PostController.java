package com.nearpoint.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nearpoint.beans.PostDTO;
import com.nearpoint.exception.ResourceNotFoundException;
import com.nearpoint.model.Post;
import com.nearpoint.repository.PostRepository;
import com.nearpoint.service.PostService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class PostController {
	
	@Autowired
	private PostService postService;

	@Autowired
    private ModelMapper modelMapper;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/posts")
	public List<PostDTO> getAllposts() {
		List<Post> posts = postService.getAllPosts();
		return posts.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	//@GetMapping("/empregados/proprietarios")
	//public List<PostDTO> findAllProprietatios(){
	//	List<Cadastro> empregados = empregadoService.getAllProprietatios();
	//	return empregados.stream()
   //     .map(this::convertToDto)
   //     .collect(Collectors.toList());
	//}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/posts/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable(value = "id") Long postId) {
		Post post = postService.getPostById(postId).get();
		return ResponseEntity.ok().body(convertToDto(post));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody PostDTO postDTO) {
		return postService.createPost(convertToEntity(postDTO));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long postId,
			@Valid @RequestBody Post postDetails) throws ResourceNotFoundException {
		Post post = postService.getPostById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado not found for this id :: " + postId));

		post.setNome(postDetails.getNome());
		final Post updatedPost = postService.updatePost(postDetails);
		return ResponseEntity.ok(updatedPost);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/posts/{id}")
	public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long postId)
			throws ResourceNotFoundException {
		Post post = postService.getPostById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado not found for this id :: " + postId));

		postService.deletePost(post);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public PostDTO convertToDto(Post post) {
		PostDTO postDTO = modelMapper.map(post, PostDTO.class);
		postDTO.setRole("Supervisão");
		return postDTO;
	}
	
	public Post convertToEntity(PostDTO postDTO) {
		Post post = modelMapper.map(postDTO, Post.class);
		return post;
	}
}
