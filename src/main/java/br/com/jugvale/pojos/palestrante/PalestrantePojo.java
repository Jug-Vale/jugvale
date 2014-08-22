package br.com.jugvale.pojos.palestrante;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.jugvale.entity.palestrante.Palestrante;

@XmlRootElement
public class PalestrantePojo {

	private String nome;
	private String email;
	private String miniCurriculum;

	public PalestrantePojo() {
	}

	public PalestrantePojo(String nome, String email, String miniCurriculum) {
		this.nome = nome;
		this.email = email;
		this.miniCurriculum = miniCurriculum;
	}

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
		return miniCurriculum;
	}

	public void setMiniCV(String miniCV) {
		this.miniCurriculum = miniCV;
	}

	public Palestrante constroiPalestrante() {
		return new Palestrante(this.nome, this.email, this.miniCurriculum);
	}
}
