package tn.esprit.testspring.services.beneficiaire;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.testspring.entities.Beneficiaire;
import tn.esprit.testspring.repositories.BeneficiaireRepo;

@Service
@AllArgsConstructor
public class BeneficiaireServiceImpl implements BeneficiaireService {

    private final BeneficiaireRepo beneficiaireRepo;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireRepo.save(bf);
    }
}
