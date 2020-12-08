package com.nearpoint.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.nearpoint.model.Post;
import com.nearpoint.model.Endereco;
import com.nearpoint.enums.Tipo;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private Tipo tipoUsuario;
	private String sobrenome;
	private byte[] fotoPerfil;
	private Endereco enderecoUsu;
	private String dataNascimento;
	private String senha;
	private List<Post> listPosts;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(long id, String nome, String email, String telefone, String cpf, Tipo tipoUsuario,
			String sobrenome,byte[]fotoPerfil, Endereco enderecoUsu, String dataNascimento, String senha,
			List<Post> listPosts) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.tipoUsuario = tipoUsuario;
		this.sobrenome = sobrenome;
		this.fotoPerfil = fotoPerfil;
		this.enderecoUsu = enderecoUsu;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.listPosts = listPosts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Tipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Tipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Endereco getEnderecoUsu() {
		return enderecoUsu;
	}

	public void setEnderecoUsu(Endereco enderecoUsu) {
		this.enderecoUsu = enderecoUsu;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
