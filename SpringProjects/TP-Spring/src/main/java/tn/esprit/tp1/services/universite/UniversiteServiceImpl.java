package tn.esprit.tp1.services.universite;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.entity.Universite;
import tn.esprit.tp1.exceptions.DepartementNotFoundException;
import tn.esprit.tp1.exceptions.UniversiteNotFoundException;
import tn.esprit.tp1.repository.UniversiteRepo;
import tn.esprit.tp1.services.departement.DepartementServiceImpl;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepo universiteRepo;
    private final DepartementServiceImpl departementService;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepo
                .findById(u.getIdUniv())
                .map(universite -> {

                    universite.setNomUniv(u.getNomUniv());

                    return universiteRepo.save(universite);
                })
                .orElseThrow(() -> new UniversiteNotFoundException(u.getIdUniv()));
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepo.findById(idUniversite).orElseThrow(() -> new UniversiteNotFoundException(idUniversite));
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {

        Universite uni = retrieveUniversite(idUniversite);

        if (uni == null) throw new UniversiteNotFoundException(idUniversite);

        Departement depart = departementService.retrieveDepartement(idDepartement);

        if (depart == null) throw new DepartementNotFoundException(idDepartement);

        uni.getDepartments().add(depart);

        log.info("Universite departments: " + uni.getDepartments().toString());

        universiteRepo.save(uni);
    }
}
