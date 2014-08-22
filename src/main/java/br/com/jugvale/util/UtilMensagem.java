package br.com.jugvale.util;

import br.com.jugvale.constantes.recurso.CodigoMensagemRecurso;
import br.com.jugvale.constantes.recurso.MensagemRecursoEnum;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;

public class UtilMensagem {

	private static String codigo;
	private static String mensagem;

	public static MensagemRecurso mensagemSucesso() {
		codigo = CodigoMensagemRecurso.SUCESSO.getCodigo();
		mensagem = MensagemRecursoEnum.SUCESSO_AO_SALVAR.getMensagem();
		return new MensagemRecurso(codigo, mensagem);
	}

	public static MensagemRecurso mensagemErro() {
		codigo = CodigoMensagemRecurso.ERRO.getCodigo();
		mensagem = MensagemRecursoEnum.ERRO_AO_SALVAR.getMensagem();
		return new MensagemRecurso(codigo, mensagem);
	}
}
