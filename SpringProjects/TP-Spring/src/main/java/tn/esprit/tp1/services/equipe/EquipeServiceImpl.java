package tn.esprit.tp1.services.equipe;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Equipe;
import tn.esprit.tp1.exceptions.EquipeNotFoundException;
import tn.esprit.tp1.repository.EquipeRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {

    private final EquipeRepo equipeRepo;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepo.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepo.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepo.findById(e.getIdEquipe())
                .map(equipe -> {

                    equipe.setNomEquipe(e.getNomEquipe());

                    return equipeRepo.save(equipe);
                })
                .orElseThrow(() -> new EquipeNotFoundException(e.getIdEquipe()));
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepo.findById(idEquipe).orElseThrow(() -> new EquipeNotFoundException(idEquipe));
    }
}
