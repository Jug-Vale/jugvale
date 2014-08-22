package br.com.jugvale.constantes.recurso;

public enum MensagemRecursoEnum {

	SUCESSO_AO_SALVAR("Sucesso Ao salvar! "), ERRO_AO_SALVAR("Erro Ao Salvar! ");

	private String mensagem;

	MensagemRecursoEnum(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

}
