package esprit.ws.graphql;

import javax.servlet.annotation.WebServlet;

import com.coxautodev.graphql.tools.SchemaParser;


import esprit.ws.reposot.StudentRepository;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

@WebServlet(urlPatterns = "/GraphQLV1")
public class GraphEndPoint extends SimpleGraphQLServlet {

	public GraphEndPoint() {
		super(buildSchema());
		// TODO Auto-generated constructor stub
	}
	
	 private static GraphQLSchema buildSchema()
	 {
		 
		 StudentRepository studentRepository=new StudentRepository();
		 return SchemaParser.newParser().file("schema.graphql")
				 .resolvers(new Query(studentRepository), 
						 new Mutation(studentRepository))
				 .build()
				 .makeExecutableSchema();
		 	 
		 
	 }

	 
}
