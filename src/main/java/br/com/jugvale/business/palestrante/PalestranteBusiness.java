package br.com.jugvale.business.palestrante;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.dao.palestrante.PalestranteDao;
import br.com.jugvale.entity.palestrante.Palestrante;
import br.com.jugvale.pojos.mensagem.MensagemRecurso;
import br.com.jugvale.pojos.palestrante.PalestrantePojo;
import br.com.jugvale.util.mensagem.UtilMensagem;

@Service("palestranteBusiness")
public class PalestranteBusiness {

	@Autowired
	private PalestranteDao palestranteDao;

	private Palestrante palestrante;
	private MensagemRecurso mensagemRecuso;

	public Response salvar(PalestrantePojo palestrantePojo) {

		try {
			this.palestrante = palestrantePojo.constroiPalestrante();
			palestranteDao.save(palestrante);

			mensagemRecuso = UtilMensagem.mensagemSucesso();

		} catch (Exception e) {
			e.printStackTrace();

			mensagemRecuso = UtilMensagem.mensagemErro();
		}

		return Response.status(Status.OK).entity(mensagemRecuso).build();
	}

	public PalestrantePojo buscaPorId(String id) {
		try {
			this.palestrante = palestranteDao.findById(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.palestrante.constroiPalestrantePojo();
	}

	public Palestrante verificaSePalestranteExiste(Palestrante palestrante) {

		try {
			String emailPalestrante = palestrante.getEmail();
			Palestrante existePalestranteComEmail = palestranteDao.findByEmail(emailPalestrante);

			if (existePalestranteComEmail == null) {
				palestranteDao.save(palestrante);
				return palestrante;
			} else {
				return existePalestranteComEmail;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return palestrante = null;
		}

	}
}
