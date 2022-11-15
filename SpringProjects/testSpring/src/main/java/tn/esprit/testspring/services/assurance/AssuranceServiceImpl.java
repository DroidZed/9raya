package tn.esprit.testspring.services.assurance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.testspring.entities.Assurance;
import tn.esprit.testspring.repositories.AssuranceRepo;

@Service
@AllArgsConstructor
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepo assuranceRepo;

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {
        return null;
    }
}
