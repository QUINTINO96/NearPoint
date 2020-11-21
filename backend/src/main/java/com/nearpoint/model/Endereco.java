package com.nearpoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Endereco {
	
	private long Id;
	private String Rua;
	private String Bairro;
	private String Complemento;
	private String Cidade;
	private String Estado;
	private String CEP;
	
	public Endereco() {
		
	}

	public Endereco(long id, String rua, String bairro, String complemento, String cidade, String estado, String cEP) {
		super();
		Id = id;
		Rua = rua;
		Bairro = bairro;
		Complemento = complemento;
		Cidade = cidade;
		Estado = estado;
		CEP = cEP;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Column(name = "rua", nullable = false)
	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	@Column(name = "bairro", nullable = false)
	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	@Column(name = "complemento", nullable = false)
	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	@Column(name = "cidade", nullable = false)
	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	@Column(name = "estado", nullable = false)
	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	@Column(name = "cep", nullable = false)
	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	@Override
	public String toString() {
		return "Endereco [Id=" + Id + ", Rua=" + Rua + ", Bairro=" + Bairro + ", Complemento=" + Complemento
				+ ", Cidade=" + Cidade + ", Estado=" + Estado + ", CEP=" + CEP + "]";
	}
	
	
	
	
	
	
	

}
