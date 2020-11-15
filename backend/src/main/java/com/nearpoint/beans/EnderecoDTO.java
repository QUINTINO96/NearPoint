package com.nearpoint.beans;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long Id;
	private String Rua;
	private String Bairro;
	private String Complemento;
	private String Cidade;
	private String Estado;
	private String CEP;
	
	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(long id, String rua, String bairro, String complemento, String cidade, String estado,
			String cEP) {
		super();
		Id = id;
		Rua = rua;
		Bairro = bairro;
		Complemento = complemento;
		Cidade = cidade;
		Estado = estado;
		CEP = cEP;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
