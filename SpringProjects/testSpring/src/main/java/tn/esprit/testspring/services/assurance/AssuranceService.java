package tn.esprit.testspring.services.assurance;

import tn.esprit.testspring.entities.Assurance;

public interface AssuranceService {

    Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);
}
