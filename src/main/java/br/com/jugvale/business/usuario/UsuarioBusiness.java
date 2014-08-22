package br.com.jugvale.business.usuario;

import static br.com.jugvale.util.exceptions.RecursoException.lancaErro;
import static br.com.jugvale.util.mensagem.UtilMensagem.naoEncontradoObjeto;
import static br.com.jugvale.util.validador.GerenciaValidaCampos.valida;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.dao.usuario.UsuarioDao;
import br.com.jugvale.entity.usuario.Usuario;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;
import br.com.jugvale.pojos.usuario.UsuarioPojo;
import br.com.jugvale.util.mensagem.UtilMensagem;
import br.com.jugvale.util.numerico.UtilNumerico;
import br.com.jugvale.util.validador.usuario.ValidaUsuario;

@Service("usuarioBusiness")
public class UsuarioBusiness implements Business {

	public UsuarioBusiness() {
	}

	public UsuarioBusiness(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Autowired
	private UsuarioDao usuarioDAO;

	private Usuario usuario;
	private MensagemRecurso mensagemRecuso;

	@Override
	public Response salvar(UsuarioPojo usuarioPojo) throws Exception {

		valida(usuarioPojo);

		try {
			this.usuario = usuarioPojo.constroiUsuario();
			usuarioDAO.save(usuario);

			mensagemRecuso = UtilMensagem.mensagemSucesso();
			return Response.status(Status.OK).entity(mensagemRecuso).build();

		} catch (Exception e) {
			mensagemRecuso = UtilMensagem.mensagemErro();
			return Response.status(Status.NOT_ACCEPTABLE).entity(mensagemRecuso).build();
		}

	}

	@Override
	public UsuarioPojo buscaPorId(String id) throws Exception {

		new ValidaUsuario().validaID(id);

		Long idLong = UtilNumerico.converteStringParaLong(id);

		try {
			usuario = usuarioDAO.findById(idLong);
			return usuario.constroiUsuarioPojo();

		} catch (Exception e) {
			UsuarioPojo usuarioPojo = new UsuarioPojo("", "", naoEncontradoObjeto());
			throw lancaErro(usuarioPojo, Status.BAD_REQUEST);
		}

	}

}
