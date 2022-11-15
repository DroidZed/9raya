package tn.esprit.tp1.services.etudiant;

import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.entity.Etudiant;

import java.util.List;


public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    void assignEtudiantToDepartement(Integer etudiantId, Integer departementId);

    Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
}
