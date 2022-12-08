package tn.esprit.testspring.services.beneficiaire;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.testspring.entities.*;
import tn.esprit.testspring.repositories.AssuranceRepo;
import tn.esprit.testspring.repositories.BeneficiaireRepo;
import tn.esprit.testspring.repositories.ContratRepo;

import java.util.*;

@Service
@AllArgsConstructor
public class BeneficiaireServiceImpl implements BeneficiaireService {

    private final BeneficiaireRepo beneficiaireRepo;
    private final ContratRepo contratRepo;
    private final AssuranceRepo assuranceRepo;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return beneficiaireRepo.save(bf);
    }

    @Override
    public Beneficiaire getOneById(Integer id) {
        return beneficiaireRepo.findById(id).orElse(null);
    }

    @Override
    public List<Beneficiaire> getAll() {
        return beneficiaireRepo.findAll();
    }

    @Override
    public ResponseEntity<?> updateOne(Beneficiaire bf) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteOne(Integer id) {

        if (!beneficiaireRepo.existsById(id))
            return new ResponseEntity<>(new RespMsg("Not found!"), HttpStatus.NOT_FOUND);

        beneficiaireRepo.deleteById(id);

        return new ResponseEntity<>(new RespMsg("id" + id + "Deleted"), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<RespMsg> deleteAll() {
        beneficiaireRepo.deleteAll();
        return new ResponseEntity<>(new RespMsg("Deleted"), HttpStatus.OK);
    }

    @Override
    public Set<Beneficiaire> getBeneficairesByType(TypeContrat typeContrat) {

        Set<Beneficiaire> benefs = new HashSet<>();

        beneficiaireRepo.findAll().forEach(b -> {

            Set<Assurance> asr = b.getAssurances();

            if (asr.isEmpty()) return;

            asr.forEach(a -> {
                if (a.getContrat().getTypeContrat().equals(typeContrat)) benefs.add(b);
            });

        });

        return benefs;
    }

    @Override
    public float getMontantBf(int cinBf) {

        Beneficiaire bf = beneficiaireRepo.findByCin(cinBf).orElse(null);

        if (bf == null) return 0;

        Map<TypeContrat, Integer> multi = new HashMap<>();

        multi.put(TypeContrat.Semestriel, 2);
        multi.put(TypeContrat.Mensuel, 12);

        List<GroupMontantTypeContrat> group = assuranceRepo.groupAssurancesByMontantAndTypeContrat(cinBf);

        if (group.isEmpty()) return 0.0f;

        return group.stream().map(g -> g.montant * multi.get(g.typeContrat)).reduce(Float::sum).get();
    }
}
