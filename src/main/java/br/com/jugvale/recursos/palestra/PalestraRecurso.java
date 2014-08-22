package br.com.jugvale.recursos.palestra;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.business.palestra.PalestraBusiness;
import br.com.jugvale.pojos.palestras.PalestraPojo;
import br.com.jugvale.recursos.RecursoGenerico;

@Service("servicoPalestraWS")
@Path("palestra")
public class PalestraRecurso implements RecursoGenerico<PalestraPojo> {

	@Autowired
	private PalestraBusiness palestraBusiness;

	@Override
	public Response cadastrar(PalestraPojo pojo) {
		return palestraBusiness.salvar(pojo);
	}

	@Override
	public PalestraPojo buscarPorId(String id) {
		return palestraBusiness.buscaPorId(id);
	}

	@Override
	public PalestraPojo buscarAtivos() {
		return null;
	}

	@Override
	public PalestraPojo buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
