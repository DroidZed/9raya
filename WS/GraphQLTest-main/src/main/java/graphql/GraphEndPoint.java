package graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;

import esprit.ws.reposot.StudentRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

@WebServlet(urlPatterns = "/GraphQLV2")
public class GraphEndPoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 1L;

	public GraphEndPoint() {
		super(buildSchema());
		// TODO Auto-generated constructor stub
	}

	private static GraphQLSchema buildSchema() {

		LogementRepository logementRepo = new LogementRepository();
		RendezVousRepository rendezVousRepo = new RendezVousRepository();

		return SchemaParser.newParser().file("schema.graphql")
				.resolvers(
						new QueryLogement(logementRepo),
						new QueryRendezVous(rendezVousRepo),
						new LogementMutation(logementRepo),
						new RendezVousMutation(rendezVousRepo)
						)
				.build().makeExecutableSchema();
	}

}
