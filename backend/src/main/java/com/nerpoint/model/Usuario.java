package com.nerpoint.model;

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


@Entity
@Table(name = "usuarios")
public class Usuario {

	private long id;
	private String Nome;
	private String Endereco;
	private String emailId;
	private String telefone;
	private String CPF;
	private String Sobrenome;
	private String NomeEmpresa;
	private List<Post> listPosts;
	
	public Usuario() {
		
	}
	



	public Usuario(long id, String nome, String endereco, String emailId, String telefone, String cPF, String sobrenome,
			String nomeEmpresa, String endereco2, List<Post> listPosts) {
		super();
		this.id = id;
		this.Nome = nome;
		this.Endereco = endereco;
		this.emailId = emailId;
		this.telefone = telefone;
		this.CPF = cPF;
		this.Sobrenome = sobrenome;
		this.NomeEmpresa = nomeEmpresa;
		this.Endereco = endereco2;
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
	
	
	@Column(name = "nome_empresa", nullable = false)
	public String getNomeEmpresa() {
		return NomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.NomeEmpresa = nomeEmpresa;
	}
	
	@Column(name="telefone", nullable = false)
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "endereco", nullable = false)
	public String getEndereco() {
		return Endereco;
	}

	
	public void setEndereco(String endereco) {
		this.Endereco = endereco;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}

	@Column(name = "email", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "cpf", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CPF_id", referencedColumnName = "id")
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Column(name = "sobrenome", nullable = false)
	public String getSobrenome() {
		return Sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	@Column(name = "posts", nullable = false)
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
		return "Usuario [id=" + id + ", Nome=" + Nome + ", Endereco=" + Endereco + ", emailId=" + emailId
				+ ", telefone=" + telefone + ", CPF=" + CPF + ", Sobrenome=" + Sobrenome + ", NomeEmpresa="
				+ NomeEmpresa + ", listPosts=" + listPosts + "]";
	}
}
