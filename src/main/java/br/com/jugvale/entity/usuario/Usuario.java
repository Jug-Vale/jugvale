package br.com.jugvale.entity.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jugvale.entity.EntidadeAbstrata;
import br.com.jugvale.pojos.usuario.UsuarioPojo;
import br.com.jugvale.util.mensagem.UtilMensagem;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeAbstrata {

	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Usuario() {
	}

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioPojo constroiUsuarioPojo() {
		UsuarioPojo pojo = new UsuarioPojo(nome, email, UtilMensagem.mensagemSucesso());
		return pojo;

	}

}
