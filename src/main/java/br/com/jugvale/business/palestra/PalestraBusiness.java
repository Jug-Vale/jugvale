package br.com.jugvale.business.palestra;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.business.palestrante.PalestranteBusiness;
import br.com.jugvale.dao.palestra.PalestraDao;
import br.com.jugvale.entity.palestra.Palestra;
import br.com.jugvale.entity.palestrante.Palestrante;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;
import br.com.jugvale.pojos.palestras.PalestraPojo;
import br.com.jugvale.util.mensagem.UtilMensagem;

@Service("palestraBusiness")
public class PalestraBusiness {

	@Autowired
	private PalestraDao palestraDao;

	@Autowired
	private PalestranteBusiness palestranteBusiness;

	private Palestra palestra;
	private MensagemRecurso mensagemRecuso;

	public Response salvar(PalestraPojo palestraPojo) {

		try {
			this.palestra = palestraPojo.constroiPalestra();

			Palestrante palestrante = palestranteBusiness.verificaSePalestranteExiste(palestra.getPalestrante());

			this.palestra.setPalestrante(palestrante);
			palestraDao.save(this.palestra);

			mensagemRecuso = UtilMensagem.mensagemSucesso();

		} catch (Exception e) {
			e.printStackTrace();
			mensagemRecuso = UtilMensagem.mensagemErro();
		}

		return Response.status(Status.OK).entity(mensagemRecuso).build();
	}

	public PalestraPojo buscaPorId(String id) {
		try {
			this.palestra = palestraDao.findById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.palestra.constroiPalestraPojo();
	}
}
