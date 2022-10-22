package tn.esprit.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.business.LogementBusiness;
import tn.esprit.entites.Logement;
import tn.esprit.entites.Type;

@Path("/logements")
@Api
@Produces(MediaType.APPLICATION_JSON)
public class LogementRessource {

	private static final LogementBusiness logementBusines = new LogementBusiness();

	@GET
	@ApiOperation(value = "List all logements", consumes = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success !") })
	public Response getAll() {

		return Response.status(Status.OK).entity(new GenericEntity<List<Logement>>(logementBusines.getLogements()) {
		}).build();
	}

	@GET
	@Path("/searchByDel")
	@ApiOperation(value = "Search for a logement by delegation", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Logement Not found !") })
	public Response getByDel(@QueryParam(value = "delegation") String query) {
		return Response.status(Status.OK).entity(searchLogements("delegation", query)).build();
	}

	@GET
	@Path("/searchByGouv")
	@ApiOperation(value = "Search for a rendezvous by gouvernorat", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Logement Not found !") })
	public Response getByGouv(@QueryParam(value = "gouvernorat") String query) {
		return Response.status(Status.OK).entity(searchLogements("gouvernorat", query)).build();
	}

	@GET
	@Path("/searchByType")
	@ApiOperation(value = "Search for a rendezvous by type", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Logement Not found !") })
	public Response getByType(@QueryParam(value = "type") Type type) {
		return Response.status(Status.OK).entity(searchLogements("type", type)).build();
	}

	@GET
	@Path("/searchByPrix")
	@ApiOperation(value = "Search for a rendezvous by prix", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Logement Not found !") })
	public Response getByType(@QueryParam(value = "prix") Float prix) {
		return Response.status(Status.OK).entity(searchLogements("prix", prix)).build();
	}

	@GET
	@Path("/searchByRef")
	@ApiOperation(value = "Search for a rendezvous by reference", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Logement Not found !") })
	public Response getByRef(@QueryParam(value = "reference") Integer prix) {
		Object logement = searchLogements("reference", prix);

		if (logement == null)
			return Response.status(Status.NOT_FOUND).build();

		return Response.status(Status.OK).entity(logement).build();
	}

	private Object searchLogements(String query, Object value) {

		Object entity = null;

		switch (query) {

		case "delegation":

			entity = new GenericEntity<List<Logement>>(logementBusines.getLogementsByDeleguation((String) value)) {
			};

			break;

		case "gouvernorat":

			entity = new GenericEntity<List<Logement>>(logementBusines.getLogementsByGouvernorat((String) value)) {
			};

			break;

		case "type":

			entity = new GenericEntity<List<Logement>>(logementBusines.getLogementsByType((Type) value)) {
			};

			break;

		case "prix":

			entity = new GenericEntity<List<Logement>>(logementBusines.getLogementsByPrix((Float) value)) {
			};

			break;

		case "reference":

			entity = new GenericEntity<Logement>(logementBusines.getLogementsByReference((Integer) value)) {
			};

			break;

		default:
			break;
		}

		return entity;

	}

}
