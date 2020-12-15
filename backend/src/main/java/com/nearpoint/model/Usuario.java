package com.nearpoint.model;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
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
	private Post anuncio;
	private List<Post> listPosts;
	private String foto;
	
	public Usuario() {
		
	}
	
	public Usuario(long id,String email,String senha)
	{
		this.id = id;
		this.email = email;
		this.senha = senha;
	}

	

	public Usuario(long id, String nome, String email, String telefone, String cpf, int tipoUsuario, String sobrenome,
			byte[] fotoPerfil, String rua, String bairro, String complemento, String cidade, String estado, String cEP,
			String dataNascimento, String senha, Post anuncio, List<Post> listPosts, String foto) {
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
		this.anuncio = anuncio;
		this.listPosts = listPosts;
		this.foto = foto;
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
	public int getTipoUsuario() {
		return tipoUsuario;
	}




	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}




	@Column(name = "sobrenome", nullable = false)
	public String getSobrenome() {
		return sobrenome;
	}




	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	

	@Column(name = "fotoPerfil", length = 700000)
	public String getFotoPerfil() throws UnsupportedEncodingException {
		
		String msgDecode = new String(fotoPerfil);
	
		return msgDecode;
	}

	public void setFotoPerfil(String fotoP) {
		
		Charset charset = Charset.forName("UTF-8");
		this.fotoPerfil = fotoP.getBytes(charset);

		
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
	public Post getAnuncio() {
		return anuncio;
		
	}
	
	public void  setAnuncio (Post anuncio) {
		this.anuncio = anuncio;
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
				+ ", tipoUsuario=" + tipoUsuario + ", sobrenome=" + sobrenome + ", fotoPerfil="
				+ Arrays.toString(fotoPerfil) + ", Rua=" + Rua + ", Bairro=" + Bairro + ", Complemento=" + Complemento
				+ ", Cidade=" + Cidade + ", Estado=" + Estado + ", CEP=" + CEP + ", dataNascimento=" + dataNascimento
				+ ", senha=" + senha + ", anuncio=" + anuncio + ", listPosts=" + listPosts + ", foto=" + foto + "]";
	}

	
}
