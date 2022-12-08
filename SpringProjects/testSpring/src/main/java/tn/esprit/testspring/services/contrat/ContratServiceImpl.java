package tn.esprit.testspring.services.contrat;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.testspring.entities.Assurance;
import tn.esprit.testspring.entities.Beneficiaire;
import tn.esprit.testspring.entities.Contrat;
import tn.esprit.testspring.repositories.BeneficiaireRepo;
import tn.esprit.testspring.repositories.ContratRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private final ContratRepo contratRepo;
    private final BeneficiaireRepo beneficiaireRepo;

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

        Beneficiaire bf = beneficiaireRepo.findById(idBf).orElse(null);

        if (bf == null) return null;

        Set<Assurance> bfAssurances = bf.getAssurances();

        List<Contrat> contratList = new ArrayList<>();

        bfAssurances.forEach(a -> contratList.add(a.getContrat()));

        contratList.sort(Collections.reverseOrder());

        return contratList.get(0);
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
