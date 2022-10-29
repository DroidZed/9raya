package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.RendezVous;
import repository.RendezVousRepository;

public class RendezVousMutation implements GraphQLRootResolver {

	private RendezVousRepository redvRepo;

	public RendezVousMutation(RendezVousRepository redvRepo) {

		this.redvRepo = redvRepo;
	}
	
	public RendezVous createRendezVous(int id, String date, String heure, int refLog, String num) {
		
		return redvRepo.addRendezVous(id, date, heure, refLog, num);
	}
	
	public RendezVous updateRendezVous(int id, String date, String heure, String num) {
		
		return redvRepo.updateRendezVous(id, date, heure, num);
		
	}
	public Boolean removeRdv(int id) {
		
		return redvRepo.deleteRendezVous(id);
		
	}

}
