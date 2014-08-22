package br.com.jugvale.recursos.usuario;

import static br.com.jugvale.util.exceptions.RecursoException.trataErro;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.business.usuario.Business;
import br.com.jugvale.pojos.usuario.UsuarioPojo;
import br.com.jugvale.recursos.RecursoGenerico;

@Service("servicoUsuarioWS")
@Path("usuario/")
public class UsuarioRecurso implements RecursoGenerico<UsuarioPojo> {

	@Autowired
	private Business usuarioBusiness;

	@Override
	public Response cadastrar(UsuarioPojo pojo) throws WebApplicationException {
		try {
			return usuarioBusiness.salvar(pojo);

		} catch (Exception e) {
			throw trataErro(e);
		}
	}

	@Override
	public UsuarioPojo buscarPorId(String id) throws WebApplicationException {
		try {
			return usuarioBusiness.buscaPorId(id);

		} catch (Exception e) {
			throw trataErro(e);
		}
	}

	@Override
	public UsuarioPojo buscarAtivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioPojo buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
