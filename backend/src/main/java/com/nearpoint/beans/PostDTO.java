package com.nearpoint.beans;

import java.io.Serializable;
import java.util.Date;


public class PostDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String Nome;
	private String role;
	
	public PostDTO() {
		
	}

	public PostDTO(long id, String nome,String role) {
		super();
		this.id = id;
		this.Nome = nome;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
