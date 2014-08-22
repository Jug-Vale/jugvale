package br.com.jugvale.business.usuario;

import javax.ws.rs.core.Response;

import br.com.jugvale.pojos.usuario.UsuarioPojo;

public interface Business {

	public Response salvar(UsuarioPojo usuarioPojo) throws Exception;

	public UsuarioPojo buscaPorId(String id) throws Exception;

}
