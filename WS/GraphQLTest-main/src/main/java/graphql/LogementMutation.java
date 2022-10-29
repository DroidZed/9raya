package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entite.Logement;
import repository.LogementRepository;

public class LogementMutation implements GraphQLRootResolver {

	private LogementRepository logRepo;

	public LogementMutation(LogementRepository logRepo) {

		this.logRepo = logRepo;
	}
	
	public Logement createLogement(int ref, String addr) {
		
		return logRepo.addLogement(ref, addr);
	}

}
