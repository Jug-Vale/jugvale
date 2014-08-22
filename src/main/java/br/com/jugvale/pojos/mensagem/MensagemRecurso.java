package br.com.jugvale.pojos.mensagem;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MensagemRecurso {

	private String codigo;
	private String mensagem;

	public MensagemRecurso(String codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public MensagemRecurso() {
	}

	public String getCodigo() {
		return codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
