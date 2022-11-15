package tn.esprit.testspring.services.contrat;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.testspring.entities.Contrat;
import tn.esprit.testspring.repositories.ContratRepo;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private final ContratRepo contratRepo;

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepo.save(c);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        Contrat c = contratRepo.findById(id).orElse(null);

        return new ResponseEntity<>(c, c != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(contratRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public Contrat getContratBf(int idBf) {



    }

    @Override
    public ResponseEntity<?> updateContrat(Contrat c) {

        Contrat contrat = contratRepo.findById(c.getIdContrat()).orElse(null);

        return new ResponseEntity<>(contrat != null ? contratRepo.save(contrat) : null, contrat != null ? HttpStatus.OK :
                HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> deleteById(Integer id) {

        if (!contratRepo.existsById(id)) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        contratRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteAll() {
        contratRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
