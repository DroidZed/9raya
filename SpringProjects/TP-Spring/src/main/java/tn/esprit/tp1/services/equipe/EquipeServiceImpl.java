package tn.esprit.tp1.services.equipe;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Equipe;
import tn.esprit.tp1.repository.EquipeRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {

    private final EquipeRepo equipeRepo;

    @Override
    public List<Equipe> listAll() {
        return null;
    }

    @Override
    public Optional<Equipe> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Equipe create(Equipe equipe) {
        return null;
    }

    @Override
    public Equipe updateOne(Long id, Equipe equipe) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
