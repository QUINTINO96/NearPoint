package com.nearpoint.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

import com.nearpoint.enums.Tipo;


@Entity
@Table(name = "usuarios")
public class Usuario {

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
	private Post anuncio;
	private List<Post> listPosts;
	
	public Usuario() {
		
	}

	public Usuario(long id, String nome, String email, String telefone, String cpf, Tipo tipoUsuario, String sobrenome, 
			byte[]fotoPerfil,Endereco enderecoUsu, String dataNascimento, String senha, Post anuncio, List<Post> listPosts) {
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
		this.anuncio = anuncio;
		this.listPosts = listPosts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}



	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	@Column(name = "telefone", nullable = false)
	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	@Column(name = "cpf", nullable = false)
	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	@Column(name = "tipo", nullable = false)
	public Tipo getTipoUsuario() {
		return tipoUsuario;
	}




	public void setTipoUsuario(Tipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}




	@Column(name = "sobrenome", nullable = false)
	public String getSobrenome() {
		return sobrenome;
	}




	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	

	@Column(name = "fotoPerfil", length = 1000)
	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	@Column(name = "endereco", nullable = false)
	public Endereco getEnderecoUsu() {
		return enderecoUsu;
	}




	public void setEnderecoUsu(Endereco enderecoUsu) {
		this.enderecoUsu = enderecoUsu;
	}




	@Column(name = "dataNascimento", nullable = false)
	public String getDataNascimento() {
		return dataNascimento;
	}




	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}




	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Post_id", referencedColumnName = "id")
	public Post getPost() {
		return anuncio;
		
	}


	@OneToMany
	@JoinColumn(name = "usuario_id")
	public List<Post> getListPosts() {
		return listPosts;
	}

	public void setListPosts(List<Post> listPosts) {
		this.listPosts = listPosts;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf
				+ ", tipoUsuario=" + tipoUsuario + ", sobrenome=" + sobrenome + ", enderecoUsu=" + enderecoUsu
				+ ", dataNascimento=" + dataNascimento + ", senha=" + senha + ", anuncio=" + anuncio + ", listPosts="
				+ listPosts + "]";
	}
}
