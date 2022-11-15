package tn.esprit.tp1.services.equipe;

import org.springframework.http.ResponseEntity;
import tn.esprit.tp1.entity.Equipe;

import java.util.List;

public interface IEquipeService {

    List<Equipe> retrieveAllEquipes();

    /**
     * ajouter l’équipe avec son détail
     */
    Equipe addEquipe(Equipe e);

    Equipe updateEquipe(Equipe e);

    Equipe retrieveEquipe(Integer idEquipe);

    ResponseEntity<?> deleteEquipe(Integer idEquipe);
}
