package com.nearpoint.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.nerpoint.model.Post;

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

	public UsuarioDTO(long id, String nomeEmpresa, String telefone, String endereco
			, List<Post> listposts, String role, String cPF, String emailId, String sobrenome,
			String nome) {
		super();
		this.id = id;
		this.NomeEmpresa = nomeEmpresa;
		this.telefone = telefone;
		this.Endereco = endereco;
		this.listPosts = listposts;
		this.role = role;
		this.Nome = nome;
		this.emailId = emailId;
		this.Sobrenome = sobrenome;
		this.CPF = cPF;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		this.Endereco = endereco;
	}

	//public Post getProprietario() {
		//return proprietario;
	//}

	//public void setProprietario(Post proprietario) {
		//this.proprietario = proprietario;
//	}

	public List<Post> getListPosts() {
		return listPosts;
	}

	public void setListPosts(List<Post> listposts) {
		this.listPosts = listposts;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
