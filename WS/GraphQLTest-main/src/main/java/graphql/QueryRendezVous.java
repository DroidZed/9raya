package graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.RendezVous;
import repository.RendezVousRepository;

public class QueryRendezVous implements GraphQLRootResolver {

	private RendezVousRepository redvRepo;

	public QueryRendezVous(RendezVousRepository redvRepo) {

		this.redvRepo = redvRepo;

	}

	List<RendezVous> getAllRdv() {
		return redvRepo.getListeRendezVous();
	}

	public List<RendezVous> getAllRdvByRefLogement(int refLog) {

		return redvRepo.getListeRendezVousByLogementReference(refLog);

	}

	public RendezVous getOneRdvById(int id) {

		return redvRepo.getRendezVousById(id);

	}

}
