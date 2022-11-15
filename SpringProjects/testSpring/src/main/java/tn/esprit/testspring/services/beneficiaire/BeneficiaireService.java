package tn.esprit.testspring.services.beneficiaire;

import org.springframework.http.ResponseEntity;
import tn.esprit.testspring.entities.Beneficiaire;

public interface BeneficiaireService {

    Beneficiaire ajouterBeneficiaire(Beneficiaire bf);

    ResponseEntity<?> getOneById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> updateOne(Beneficiaire bf);

    ResponseEntity<?> deleteOne();

    ResponseEntity<?> deleteAll();
}
