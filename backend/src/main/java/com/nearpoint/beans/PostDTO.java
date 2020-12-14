package com.nearpoint.beans;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;


public class PostDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private byte[] fotoanuncio;
	private String titulo;
	private String descricao;
	private long idUsu;
	
	public PostDTO() {
		
	}

	public PostDTO(long id, byte[] fotoanuncio, String titulo, String descricao, long idUsu) {
		super();
		this.id = id;
		this.fotoanuncio = fotoanuncio;
		this.titulo = titulo;
		this.descricao = descricao;
		this.idUsu = idUsu;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFotoanuncio() {
		String msgDecode = new String(fotoanuncio);
		
		return msgDecode;
	}

	public void setFotoanuncio(String fotoanuncio) {
		Charset charset = Charset.forName("UTF-8");
		this.fotoanuncio = fotoanuncio.getBytes(charset);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public long getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(long idUsu) {
		this.idUsu = idUsu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
