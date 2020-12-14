package com.nearpoint.model;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
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
	private String descricao;
	private long idUsu;
	
	 @OneToOne(cascade = CascadeType.ALL, mappedBy = "Usuario")
	    private Usuario usuario;
	
	
	
	public Post() {
		
	}
	
	

	public Post(long id, byte[] fotoanuncio, String titulo, String descricao,long idUsu) {
		super();
		this.id = id;
		this.fotoanuncio = fotoanuncio;
		this.titulo = titulo;
		this.descricao = descricao;
		this.idUsu = idUsu;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	@Column(name = "fotoAnuncio", length = 700000)
	public String getFotoanuncio() {
		String msgDecode = new String(fotoanuncio);
		
		return msgDecode;
	}



	public void setFotoanuncio(String fotoanuncio) {
		Charset charset = Charset.forName("UTF-8");
		this.fotoanuncio = fotoanuncio.getBytes(charset);
	}



	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}





	@Column(name = "descricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	



	@Column(name = "idUsu", nullable = false)
	public long getIdUsu() {
		return idUsu;
	}



	public void setIdUsu(long idUsu) {
		this.idUsu = idUsu;
	}



	@Override
	public String toString() {
		return "Post [id=" + id + ", fotoanuncio=" + Arrays.toString(fotoanuncio) + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", idUsu=" + idUsu + ", usuario=" + usuario + "]";
	}
	
}
