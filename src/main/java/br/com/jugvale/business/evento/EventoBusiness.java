package br.com.jugvale.business.evento;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.dao.evento.EventoDao;
import br.com.jugvale.entity.evento.Evento;
import br.com.jugvale.pojos.evento.EventoPojo;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;
import br.com.jugvale.util.mensagem.UtilMensagem;

@Service("eventoBusiness")
public class EventoBusiness {

	public EventoBusiness() {
	}

	public EventoBusiness(EventoDao eventoDao) {
		this.eventoDao = eventoDao;
	}

	@Autowired
	private EventoDao eventoDao;
	private Evento evento;
	private MensagemRecurso mensagemRecuso;

	public Response salvar(EventoPojo eventoPojo) {

		try {
			this.evento = eventoPojo.constroiEvento();
			eventoDao.save(evento);

			mensagemRecuso = UtilMensagem.mensagemSucesso();
			return Response.status(Status.OK).entity(mensagemRecuso).build();

		} catch (Exception e) {
			e.printStackTrace();

			mensagemRecuso = UtilMensagem.mensagemErro();
			return Response.status(Status.NOT_ACCEPTABLE).entity(mensagemRecuso).build();
		}

	}

	public EventoPojo buscaPorId(String id) {
		try {
			this.evento = eventoDao.findById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.evento.constroiEventoPojo();
	}

	public EventoPojo buscaUltimoEventoAtivo() {
		try {
			this.evento = eventoDao.buscarUltimoEventoAtivo();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.evento.constroiEventoPojo();
	}
}
