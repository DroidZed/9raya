package tn.esprit.tp1.services.departement;

import tn.esprit.tp1.entity.Departement;

import java.util.List;

public interface IDepartementService {

    List<Departement> retrieveAllDepartements();

    Departement addDepartement(Departement d);

    Departement updateDepartement(Departement d);

    Departement retrieveDepartement(Integer idDepart);
}
