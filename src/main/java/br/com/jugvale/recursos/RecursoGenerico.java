package br.com.jugvale.recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public interface RecursoGenerico<T> {

	@POST
	@Path("cadastrar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response cadastrar(T pojo) throws WebApplicationException;

	@GET
	@Produces("application/json")
	@Path("buscar/{id}")
	public T buscarPorId(@PathParam("id") String id) throws WebApplicationException;

	@GET
	@Produces("application/json")
	@Path("buscar/ativos")
	public T buscarAtivos() throws WebApplicationException;

	@GET
	@Produces("application/json")
	@Path("buscar")
	public T buscarTodos() throws WebApplicationException;

}
