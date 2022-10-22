package jaxrs.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jaxrs.entities.Employe;
import jaxrs.filters.Secured;

@Secured
@Path("employes")
public class GestionEmploye {

	static List<Employe> employes = new ArrayList<Employe>();

	public GestionEmploye() {
		super();
		// TODO Auto-generated constructor stub
		employes.add(new Employe("2222222", "Ali", "Ben ahmed"));

	}

	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces("application/xml")
	public Response afficherListeEmployes() {
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET").entity(employes).build();
	}

	// @Secured
	@Path("post")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterEmploye(Employe employe) {
		employes.add(employe);
		return Response.status(201).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST").entity("done5").build();

	}

	@GET
	@Path("{c}")
	@Produces("application/xml")
	public Employe chercherEmploye(@PathParam("c") String cin) {
		int index = this.getIndexByCin(cin);
		if (index != -1) {
			return employes.get(index);
		}
		return null;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public String updateEmploye(Employe e) {
		int index = getIndexByCin(e.getCin());

		if (index != -1) {
			employes.set(index, e);
			return "update successful";
		}
		return "update unsuccessful";
	}

	@DELETE
	@Path("{c}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmploye(@PathParam("c") String cin) {
		int index = getIndexByCin(cin);
		if (index != -1) {
			employes.remove(index);
			return "true";
		} else
			return "false";
	}

	public int getIndexByCin(String cin) {
		for (Employe emp : employes) {
			if (emp.getCin().equals(cin))
				return employes.indexOf(emp);
		}
		return -1;
	}
}
