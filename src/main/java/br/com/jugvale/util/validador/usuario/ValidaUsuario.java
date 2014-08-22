package br.com.jugvale.util.validador.usuario;

import static br.com.jugvale.util.exceptions.RecursoException.lancaErro;
import static br.com.jugvale.util.mensagem.UtilMensagem.camposObrigatorios;
import static br.com.jugvale.util.mensagem.UtilMensagem.idInvalidoOuZero;
import static br.com.jugvale.util.mensagem.UtilMensagem.naoEncontradoObjeto;

import javax.ws.rs.core.Response.Status;

import br.com.jugvale.pojos.usuario.UsuarioPojo;
import br.com.jugvale.util.validador.Valida;

public class ValidaUsuario implements Valida {

	private final UsuarioPojo usuarioPojo;

	public ValidaUsuario() {
		usuarioPojo = new UsuarioPojo();
	}

	public ValidaUsuario(Object usuarioPojo) {
		this.usuarioPojo = (UsuarioPojo) usuarioPojo;
		valida();
	}

	@Override
	public void valida() {
		objetoEhNulo(usuarioPojo);
		validaNome();
		validaEmail();
	}

	@Override
	public void validaID(String id) {

		UsuarioPojo usuarioPojo = new UsuarioPojo("", "", idInvalidoOuZero());

		if (id.equals("") || id.equals("0")) {
			throw lancaErro(usuarioPojo, Status.BAD_REQUEST);
		}

		try {
			Long.parseLong(id);
		} catch (Exception e) {
			throw lancaErro(usuarioPojo, Status.BAD_REQUEST);
		}
	}

	@Override
	public void objetoEhNulo(Object objeto) {

		if (objeto == null) {
			throw lancaErro(naoEncontradoObjeto(), Status.BAD_REQUEST);
		}
	}

	protected void validaNome() {
		String nome = usuarioPojo.getNome();

		if (nome.equals("") || nome == null) {
			throw lancaErro(camposObrigatorios("O Nome é um campo Obrigatório e "), Status.BAD_REQUEST);
		}
	}

	protected void validaEmail() {
		String email = usuarioPojo.getEmail();

		if (email.equals("") || email == null) {
			throw lancaErro(camposObrigatorios("O Email é um campo Obrigatório e "), Status.BAD_REQUEST);
		}
	}

}
