package com.nearpoint.beans;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

import com.nearpoint.model.Post;


public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private int tipoUsuario;
	private String sobrenome;
	private byte[] fotoPerfil;
	private String Rua;
	private String Bairro;
	private String Complemento;
	private String Cidade;
	private String Estado;
	private String CEP;
	private String dataNascimento;
	private String senha;
	private List<Post> listPosts;
	
	public UsuarioDTO() {
		super();
	}

	
	public UsuarioDTO(long id, String nome, String email, String telefone, String cpf, int tipoUsuario,
			String sobrenome, byte[] fotoPerfil, String rua, String bairro, String complemento, String cidade,
			String estado, String cEP, String dataNascimento, String senha, List<Post> listPosts) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.tipoUsuario = tipoUsuario;
		this.sobrenome = sobrenome;
		this.fotoPerfil = fotoPerfil;
		Rua = rua;
		Bairro = bairro;
		Complemento = complemento;
		Cidade = cidade;
		Estado = estado;
		CEP = cEP;
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

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getFotoPerfil() {
		String msgDecode = new String(fotoPerfil);
		
		return msgDecode;
	}

	public void setFotoPerfil(String fotoP) {
		
		Charset charset = Charset.forName("UTF-8");
		this.fotoPerfil = fotoP.getBytes(charset);

	}

	public String getRua() {
		return Rua;
	}


	public void setRua(String rua) {
		Rua = rua;
	}


	public String getBairro() {
		return Bairro;
	}


	public void setBairro(String bairro) {
		Bairro = bairro;
	}


	public String getComplemento() {
		return Complemento;
	}


	public void setComplemento(String complemento) {
		Complemento = complemento;
	}


	public String getCidade() {
		return Cidade;
	}


	public void setCidade(String cidade) {
		Cidade = cidade;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public String getCEP() {
		return CEP;
	}


	public void setCEP(String cEP) {
		CEP = cEP;
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
