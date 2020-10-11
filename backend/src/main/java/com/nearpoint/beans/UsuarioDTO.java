package com.nearpoint.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.nearpoint.model.Post;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String role;
	private String Nome;
	private String Endereco;
	private String emailId;
	private String telefone;
	private String CPF;
	private String Sobrenome;
	private String NomeEmpresa;
	private List<Post> listPosts;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(long id, String role, String nome, String endereco, String emailId, String telefone, String cPF,
			String sobrenome, String nomeEmpresa, List<Post> listPosts) {
		super();
		this.id = id;
		this.role = role;
		Nome = nome;
		Endereco = endereco;
		this.emailId = emailId;
		this.telefone = telefone;
		CPF = cPF;
		Sobrenome = sobrenome;
		NomeEmpresa = nomeEmpresa;
		this.listPosts = listPosts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public String getNomeEmpresa() {
		return NomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		NomeEmpresa = nomeEmpresa;
	}

	public List<Post> getListPosts() {
		return listPosts;
	}

	public void setListPosts(List<Post> listPosts) {
		this.listPosts = listPosts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
