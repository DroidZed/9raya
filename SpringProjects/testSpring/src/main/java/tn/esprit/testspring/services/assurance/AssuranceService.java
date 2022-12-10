package tn.esprit.testspring.services.assurance;

import tn.esprit.testspring.entities.Assurance;

import java.util.List;

public interface AssuranceService {

    Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);

    List<Assurance> getAllAssurances();
}
