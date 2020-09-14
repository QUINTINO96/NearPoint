package com.nerpoint.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class Post {
	/*Nome, Endereço, E-mail, Telefone, CPF,
Data de Nascimento, Função (Tipo Enumerado com as opções: ADMINISTRATIVO,
SUPERVISÃO, GERÊNCIA, PROPRIETÁRIO) e salário.*/
	
	private long id;
	private String Nome;
	private String role;
	
	//@OneToOne(mappedBy = "proprietario")
    //private Empresa empresa;
	
	public Post() {
		
	}
	
	public Post(long id, String nome) {
		super();
		this.id = id;
		this.Nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome_Completo", nullable = false)
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}

	@Column(name= "Role",nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", Nome=" + Nome + ", role=" + role + "]";
	}


	
}
