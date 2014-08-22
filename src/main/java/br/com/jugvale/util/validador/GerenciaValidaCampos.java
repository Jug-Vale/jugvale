package br.com.jugvale.util.validador;

import br.com.jugvale.pojos.usuario.UsuarioPojo;
import br.com.jugvale.util.validador.usuario.ValidaUsuario;

public class GerenciaValidaCampos {

	public GerenciaValidaCampos() {
	}

	public static void valida(Object objeto) {

		if (objeto instanceof UsuarioPojo) {
			new ValidaUsuario(objeto);
		}

	}

}
