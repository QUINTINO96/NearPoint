package com.nearpoint.beans;

import java.io.Serializable;
import java.util.Date;


public class PostDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private byte[] fotoanuncio;
	private String titulo;
	private String descrição;
	
	public PostDTO() {
		
	}

	public PostDTO(long id, byte[] fotoanuncio, String titulo, String descrição) {
		super();
		this.id = id;
		this.fotoanuncio = fotoanuncio;
		this.titulo = titulo;
		this.descrição = descrição;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getFotoanuncio() {
		return fotoanuncio;
	}

	public void setFotoanuncio(byte[] fotoanuncio) {
		this.fotoanuncio = fotoanuncio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
