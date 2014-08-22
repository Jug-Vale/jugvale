package br.com.jugvale.util.exceptions;

import javax.persistence.NoResultException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RecursoException {
	public static WebApplicationException lancaErro(Object objeto, Status status) {
		throw new WebApplicationException(Response.status(status).entity(objeto).build());
	}

	public static WebApplicationException trataErro(Exception erro) {
		if (erro instanceof NoResultException) {
			return new WebApplicationException(404);
		} else if (erro instanceof WebApplicationException) {
			return (WebApplicationException) erro;
		}

		else {
			System.out.println("Erro: " + erro.getCause());
			return new WebApplicationException(500);
		}

	}
}
