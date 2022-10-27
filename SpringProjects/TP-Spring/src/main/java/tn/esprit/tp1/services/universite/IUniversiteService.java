package tn.esprit.tp1.services.universite;

import tn.esprit.tp1.entity.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(Integer idUniversite);

    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
