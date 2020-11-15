package com.nearpoint.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "post")
public class Post {
	
	
	private long id;
	private byte[] fotoanuncio;
	private String titulo;
	private String descrição;
	
	
	
	public Post() {
		
	}
	
	

	public Post(long id, byte[] fotoanuncio, String titulo, String descrição) {
		super();
		this.id = id;
		this.fotoanuncio = fotoanuncio;
		this.titulo = titulo;
		this.descrição = descrição;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	@Column(name = "fotoAnuncio", length = 1000)
	public byte[] getFotoanuncio() {
		return fotoanuncio;
	}



	public void setFotoanuncio(byte[] fotoanuncio) {
		this.fotoanuncio = fotoanuncio;
	}



	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	@Column(name = "descricao", nullable = false)
	public String getDescrição() {
		return descrição;
	}



	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}



	@Override
	public String toString() {
		return "Post [id=" + id + ", fotoanuncio=" + Arrays.toString(fotoanuncio) + ", titulo=" + titulo
				+ ", descrição=" + descrição + "]";
	}
	
	
	
}
