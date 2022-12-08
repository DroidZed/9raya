package tn.esprit.tp1.services.etudiant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.entity.Equipe;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.exceptions.DepartementNotFoundException;
import tn.esprit.tp1.exceptions.EtudiantNotFoundException;
import tn.esprit.tp1.repository.EtudiantRepo;
import tn.esprit.tp1.services.contrat.ContratServiceImpl;
import tn.esprit.tp1.services.departement.DepartementServiceImpl;
import tn.esprit.tp1.services.equipe.EquipeServiceImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;
    private final DepartementServiceImpl departementService;

    private final ContratServiceImpl contratService;

    private final EquipeServiceImpl equipeService;

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

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepo.findByNomAndPrenom(nomE, prenomE);

        if (e == null) return null;

        if (e.getContrats().size() == 5) return null;

        e.getContrats().add(ce);

        e.setContrats(e.getContrats());

        return ce;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {

        Departement d = departementService.retrieveDepartement(idDepartement);

        if (d == null) return new ArrayList<>();

        return etudiantRepo.findAllByDepartement(d);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {

        if (e == null) return null;

        Contrat c = contratService.retrieveContrat(idContrat);

        if (c == null) return null;

        Equipe eq = equipeService.retrieveEquipe(idEquipe);

        if (eq == null) return null;

        e.getContrats().add(c);

        e.getEquipes().add(eq);

        return etudiantRepo.save(e);
    }
}
