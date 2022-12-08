package tn.esprit.testspring.services.beneficiaire;

import org.springframework.http.ResponseEntity;
import tn.esprit.testspring.entities.Beneficiaire;
import tn.esprit.testspring.entities.TypeContrat;

import java.util.List;
import java.util.Set;

public interface BeneficiaireService {

    Beneficiaire ajouterBeneficiaire(Beneficiaire bf);

    Beneficiaire getOneById(Integer id);

    List<Beneficiaire> getAll();

    ResponseEntity<?> updateOne(Beneficiaire bf);

    ResponseEntity<?> deleteOne(Integer id);

    ResponseEntity<?> deleteAll();

    Set<Beneficiaire> getBeneficairesByType (TypeContrat typeContrat);

    float getMontantBf (int cinBf);
}
