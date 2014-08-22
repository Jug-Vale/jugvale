package br.com.jugvale.pojos.usuario;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.jugvale.entity.usuario.Usuario;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;

@XmlRootElement
public class UsuarioPojo {

	private String nome;
	private String email;
	private MensagemRecurso mensagem;

	public UsuarioPojo(String nome, String email, MensagemRecurso mensagem) {
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
	}

	public UsuarioPojo() {
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

	public MensagemRecurso getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemRecurso mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario constroiUsuario() {
		return new Usuario(nome, email);
	}
}
