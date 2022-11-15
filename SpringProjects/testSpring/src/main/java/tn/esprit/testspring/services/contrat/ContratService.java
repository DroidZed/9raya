package tn.esprit.testspring.services.contrat;

import org.springframework.http.ResponseEntity;
import tn.esprit.testspring.entities.Contrat;

import java.util.List;

public interface ContratService {

    Contrat ajouterContrat(Contrat c);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    Contrat getContratBf(int idBf);

    ResponseEntity<?> updateContrat(Contrat c);

    ResponseEntity<?> deleteById(Integer id);

    ResponseEntity<?> deleteAll();
}
