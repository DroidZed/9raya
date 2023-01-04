package tn.esprit.tp1.services.etudiant;

import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.entity.Option;
import tn.esprit.tp1.entity.Specialite;

import java.util.List;
import java.util.Map;


public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    void assignEtudiantToDepartement(Integer etudiantId, Integer departementId);

    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);

    List<Etudiant> getEtudiantsByDepartement(Integer idDepartement);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    Map<Option, List<Etudiant>> listEtudiantsParOption();

    Map<String, Integer> countStudentsByOption(Option o);

    Map<Specialite, Integer> countEtudiantsParSpecialite(Specialite s);
}
