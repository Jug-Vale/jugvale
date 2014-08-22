package br.com.jugvale.constantes.recurso;

public enum CodigoMensagemRecurso {
	SUCESSO("200"), FALTANDO_DADOS("300"), ERRO("400");

	private String codigo;

	CodigoMensagemRecurso(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
