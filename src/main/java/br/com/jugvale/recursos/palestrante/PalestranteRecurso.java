package br.com.jugvale.recursos.palestrante;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jugvale.business.palestrante.PalestranteBusiness;
import br.com.jugvale.pojos.palestrante.PalestrantePojo;
import br.com.jugvale.recursos.RecursoGenerico;

@Service("servicoPalestranteWS")
@Path("palestrante/")
public class PalestranteRecurso implements RecursoGenerico<PalestrantePojo> {

	@Autowired
	private PalestranteBusiness palestranteBusiness;

	@Override
	public Response cadastrar(PalestrantePojo pojo) {
		return palestranteBusiness.salvar(pojo);
	}

	@Override
	public PalestrantePojo buscarPorId(String id) {
		return palestranteBusiness.buscaPorId(id);
	}

	@Override
	public PalestrantePojo buscarAtivos() {
		return null;
	}

	@Override
	public PalestrantePojo buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
