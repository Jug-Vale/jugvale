package br.com.jugvale.entity.palestrante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jugvale.entity.EntidadeAbstrata;
import br.com.jugvale.pojos.palestrante.PalestrantePojo;

@Entity
@Table(name = "palestrante")
public class Palestrante extends EntidadeAbstrata {

	public Palestrante() {
	}

	public Palestrante(String nome, String email, String miniCV) {
		this.nome = nome;
		this.email = email;
		this.miniCV = miniCV;
	}

	private static final long serialVersionUID = 1L;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "email", nullable = true, length = 50)
	private String email;

	@Column(name = "mini_cv", nullable = false, length = 500)
	private String miniCV;

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

	public String getMiniCV() {
		return miniCV;
	}

	public void setMiniCV(String miniCV) {
		this.miniCV = miniCV;
	}

	public PalestrantePojo constroiPalestrantePojo() {
		return new PalestrantePojo(this.nome, this.email, this.miniCV);
	}

}
