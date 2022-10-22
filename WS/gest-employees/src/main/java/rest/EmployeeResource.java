package rest;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import dto.ResponseDTO;
import entities.Employee;
import utils.Consts;


@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	private static List<Employee> EMPLOYEES = new ArrayList<>();

	private static Response NOT_FOUND_RESP = Response.status(Status.NOT_FOUND).entity(Consts.NOT_FOUND_ENTITY).build();

	private static Response FOUND_RESP = Response.status(Status.CONFLICT).entity(Consts.FOUND_ENTITY).build();

	private static Response OK_RESP = Response.status(Status.OK).entity(Consts.OK_ENTITY).build();

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee empl) {

		if (EMPLOYEES.stream().anyMatch(e -> e.equals(empl)))
			return FOUND_RESP;

		else {
			EMPLOYEES.add(empl);
			return Response.status(Status.CREATED).entity(new GenericEntity<Employee>(empl) {
			}).build();
		}
	}

	@GET
	@Path("/search")
	public Response searchEmployee(@QueryParam(value = "cin") String cin) {

		Employee employee = EMPLOYEES.stream().filter(e -> e.getCin().equals(cin)).findFirst().orElse(null);
		Integer statusCode = 302;

		GenericEntity<Employee> entity = null;

		try {

			entity = new GenericEntity<Employee>(employee) {
			};
		}

		catch (IllegalArgumentException e) {
			statusCode = 404;
		}

		return Response.status(statusCode).entity(entity == null ? new ResponseDTO("Employee not found") : entity)
				.build();
	}

	@GET
	@Path("/list")
	public Response displayEmployeesList() {

		GenericEntity<List<Employee>> employees = new GenericEntity<List<Employee>>(EMPLOYEES) {
		};

		return EMPLOYEES.size() == 0 ? NOT_FOUND_RESP : Response.status(Status.OK).entity(employees).build();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@QueryParam(value = "cin") String cin, Employee newEmp) {

		Employee emp = EMPLOYEES.stream().filter(e -> e.getCin().equals(cin)).findFirst().orElse(null);

		if (emp == null)
			return NOT_FOUND_RESP;

		EMPLOYEES.get(EMPLOYEES.indexOf(emp)).setNom(newEmp.getNom());
		EMPLOYEES.get(EMPLOYEES.indexOf(emp)).setPrenom(newEmp.getPrenom());

		return OK_RESP;
	}

	@DELETE
	@Path("/delete/{cin}")
	public Response deleteEmployee(@PathParam(value = "cin") String cin) {

		Employee emp = EMPLOYEES.stream().filter(e -> e.getCin().equals(cin)).findFirst().orElse(null);

		if (emp == null)
			return NOT_FOUND_RESP;

		EMPLOYEES.remove(emp);

		return OK_RESP;

	}

}
