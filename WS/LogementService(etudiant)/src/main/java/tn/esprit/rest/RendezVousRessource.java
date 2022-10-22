package tn.esprit.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;

@Api
@Path("/rendezvous")
public class RendezVousRessource {

	private static final RendezVousBusiness rdvBusiness = new RendezVousBusiness();

	// CREATE
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Creata a rendezvous", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 201, message = "Created !"), @ApiResponse(code = 406, message = "Error !") })
	public Response createRdv(RendezVous rdv) {

		return Response.status(rdvBusiness.addRendezVous(rdv) ? Status.CREATED : Status.NOT_ACCEPTABLE).build();
	}

	// READ
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get all rendezvous", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "Success !") })
	public Response getAll() {

		GenericEntity<List<RendezVous>> entity = new GenericEntity<List<RendezVous>>(rdvBusiness.getListeRendezVous()) {
		};

		return Response.status(Status.OK).entity(entity).build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Search for a rendezvous by refLogement", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Rendez-vous Not found !") })
	public Response getByRefLogement(@QueryParam(value = "refLogement") Integer refLogement) {

		List<RendezVous> listeRendezVousByLogementReference = rdvBusiness
				.getListeRendezVousByLogementReference(refLogement);

		if (listeRendezVousByLogementReference.isEmpty())
			return Response.status(Status.NOT_FOUND).build();

		GenericEntity<List<RendezVous>> entity = new GenericEntity<List<RendezVous>>(
				listeRendezVousByLogementReference) {
		};

		return Response.status(Status.OK).entity(entity).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get a rendezvous by id", produces = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK !"),
			@ApiResponse(code = 404, message = "Rendez-vous Not found !") })
	public Response getById(@PathParam(value = "id") Integer id) {

		RendezVous listeRendezVousByLogementReference = rdvBusiness.getRendezVousById(id);

		if (listeRendezVousByLogementReference == null)
			return Response.status(Status.NOT_FOUND).build();

		GenericEntity<RendezVous> entity = new GenericEntity<RendezVous>(listeRendezVousByLogementReference) {
		};

		return Response.status(Status.OK).entity(entity).header("Access-Control-Allow-Origin", "*").build();
	}

	// UPDATE
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Update a rendezvous", consumes = MediaType.APPLICATION_JSON)
	@ApiResponses({ @ApiResponse(code = 200, message = "Updated !"),
			@ApiResponse(code = 404, message = "Rendez-vous Not found !") })
	public Response updateRdv(@PathParam(value = "id") Integer id, RendezVous newRdv) {

		return Response.status(rdvBusiness.updateRendezVous(id, newRdv) ? Status.OK : Status.NOT_FOUND).build();
	}

	// DELETE
	@DELETE
	@Path("{id}")
	@ApiOperation(value = "Delete a rendezvous")
	@ApiResponses({ @ApiResponse(code = 200, message = "Deleted !"),
			@ApiResponse(code = 404, message = "Rendez-vous Not found !") })
	public Response deleteRdv(@PathParam(value = "id") Integer id) {

		return Response.status(rdvBusiness.deleteRendezVous(id) ? Status.OK : Status.NOT_FOUND).build();
	}
}
