package br.com.jugvale.recursos.evento;

import static br.com.jugvale.util.exceptions.RecursoException.trataErro;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.business.evento.EventoBusiness;
import br.com.jugvale.pojos.evento.EventoPojo;
import br.com.jugvale.recursos.RecursoGenerico;

@Service("servicoEventoWS")
@Path("evento/")
public class EventoRecuro implements RecursoGenerico<EventoPojo> {

	@Autowired
	private EventoBusiness eventoBusiness;

	@Override
	public Response cadastrar(EventoPojo pojo) {
		return eventoBusiness.salvar(pojo);
	}

	@Override
	public EventoPojo buscarPorId(String id) throws WebApplicationException {
		try {
			return eventoBusiness.buscaPorId(id);
		} catch (Exception e) {
			throw trataErro(e);
		}
	}

	@Override
	public EventoPojo buscarAtivos() {
		return eventoBusiness.buscaUltimoEventoAtivo();
	}

	@Override
	public EventoPojo buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
