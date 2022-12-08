package tn.esprit.tp1.services.contrat;

import tn.esprit.tp1.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    List<Contrat> retrieveAllContrats();

    Contrat updateContrat(Contrat ce);

    Contrat addContrat(Contrat ce);

    Contrat retrieveContrat(Integer idContrat);

    void removeContrat(Integer idContrat);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    Integer nbContratsValides(Date startDate, Date endDate);
}
