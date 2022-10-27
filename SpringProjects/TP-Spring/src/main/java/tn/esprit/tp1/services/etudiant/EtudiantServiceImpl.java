package tn.esprit.tp1.services.etudiant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.exceptions.DepartementNotFoundException;
import tn.esprit.tp1.exceptions.EtudiantNotFoundException;
import tn.esprit.tp1.repository.EtudiantRepo;
import tn.esprit.tp1.services.departement.DepartementServiceImpl;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;
    private final DepartementServiceImpl departementService;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.findById(e.getIdEtudiant())
                .map(etudiant -> {

                    etudiant.setNom(e.getNom());
                    etudiant.setPrenom(e.getPrenom());
                    etudiant.setOption(e.getOption());

                    return etudiantRepo.save(etudiant);
                })
                .orElseThrow(() -> new EtudiantNotFoundException(e.getIdEtudiant()));
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElseThrow(() -> new EtudiantNotFoundException(idEtudiant));
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {

        if (!etudiantRepo.existsById(idEtudiant))
            throw new EtudiantNotFoundException(idEtudiant);

        etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {

        Departement depart = departementService.retrieveDepartement(departementId);

        if (depart == null) throw new DepartementNotFoundException(departementId);

        Etudiant etudiant = retrieveEtudiant(etudiantId);

        if (etudiant == null) throw new EtudiantNotFoundException(etudiantId);

        etudiant.setDepartement(depart);

        etudiantRepo.save(etudiant);

    }


}
