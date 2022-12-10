package tn.esprit.testspring.services.assurance;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.testspring.entities.Assurance;
import tn.esprit.testspring.entities.Beneficiaire;
import tn.esprit.testspring.entities.Contrat;
import tn.esprit.testspring.repositories.AssuranceRepo;
import tn.esprit.testspring.repositories.BeneficiaireRepo;
import tn.esprit.testspring.repositories.ContratRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepo assuranceRepo;
    private final BeneficiaireRepo beneficiaireRepo;
    private final ContratRepo contratRepo;

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule) {

        if (a == null) return null;

        Beneficiaire bf = beneficiaireRepo.findBeneficiaireByCin(cinBf).orElse(null);

        if (bf == null) return null;

        Contrat ct = contratRepo.findContratByMatricule(matricule).orElse(null);

        if (ct == null) return null;

        a.setContrat(ct);
        a.setBeneficiaire(bf);

        return assuranceRepo.save(a);
    }

    @Override
    public List<Assurance> getAllAssurances() {
        return assuranceRepo.findAll();
    }
}
