package tn.esprit.tp1.services.departement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.exceptions.DepartementNotFoundException;
import tn.esprit.tp1.repository.DepartementRepo;
import tn.esprit.tp1.services.universite.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements IDepartementService {

    private final DepartementRepo departementRepo;
    private final UniversiteServiceImpl universiteService;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepo.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepo.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepo.findById(d.getIdDepart())
                .map(dept -> {

                    dept.setNomDepart(d.getNomDepart());

                    return departementRepo.save(dept);
                })
                .orElseThrow(() -> new DepartementNotFoundException(d.getIdDepart()));
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepo.findById(idDepart).orElseThrow(() -> new DepartementNotFoundException(idDepart));
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return new ArrayList<>(universiteService
                .retrieveUniversite(idUniversite)
                .getDepartments());
    }
}
