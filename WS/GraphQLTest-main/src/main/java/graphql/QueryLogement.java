package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import entite.Type;
import esprit.ws.entities.Student;

import esprit.ws.reposot.StudentRepository;
import repository.LogementRepository;

public class QueryLogement implements GraphQLRootResolver {

	private LogementRepository logRepo;

	public QueryLogement(LogementRepository logRepo) {
		this.logRepo = logRepo;
	}

	public List<Logement> getAllLogements() {

		return logRepo.getLogements();

	}

	public Logement getOneLogementByRef(int ref) {

		return logRepo.getLogementsByReference(ref);
	}

	public List<Type> getAllByType(Type type) {
		return logRepo.getLogementsByType(type);
	}
}
