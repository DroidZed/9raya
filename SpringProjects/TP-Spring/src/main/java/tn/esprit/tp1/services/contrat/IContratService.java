package tn.esprit.tp1.services.contrat;

import tn.esprit.tp1.entity.Contrat;

import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrats();

    Contrat updateContrat(Contrat ce);

    Contrat addContrat(Contrat ce);

    Contrat retrieveContrat(Integer idContrat);

    void removeContrat(Integer idContrat);
}
