package br.com.jugvale.util.mensagem;

import br.com.jugvale.constantes.recurso.CodigoMensagemConstante;
import br.com.jugvale.constantes.recurso.MensagemRecursoConstante;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;

public class UtilMensagem {

	private static String codigo;
	private static String mensagem;

	public static MensagemRecurso mensagemSucesso() {
		codigo = CodigoMensagemConstante.SUCESSO;
		mensagem = MensagemRecursoConstante.SUCESSO;
		return new MensagemRecurso(codigo, mensagem);
	}

	public static MensagemRecurso mensagemErro() {
		codigo = CodigoMensagemConstante.ERRO;
		mensagem = MensagemRecursoConstante.ERRO_AO_SALVAR;
		return new MensagemRecurso(codigo, mensagem);
	}

	public static MensagemRecurso idInvalidoOuZero() {
		codigo = CodigoMensagemConstante.ID_INVALIDO;
		mensagem = MensagemRecursoConstante.ID_ZERO_OU_INVALIDO;
		return new MensagemRecurso(codigo, mensagem);
	}

	public static MensagemRecurso naoEncontradoObjeto() {
		codigo = CodigoMensagemConstante.OBJETO_NAO_ENCONTRADO;
		mensagem = MensagemRecursoConstante.OBJETO_NAO_ENCONTRADO;
		return new MensagemRecurso(codigo, mensagem);
	}

	public static MensagemRecurso camposObrigatorios(String complementoMensagem) {
		codigo = CodigoMensagemConstante.CAMPOS_OBRIGATORIOS;
		mensagem = complementoMensagem + MensagemRecursoConstante.CAMPOS_OBRIGATORIOS;
		return new MensagemRecurso(codigo, mensagem);
	}
}
