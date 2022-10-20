package tn.esprit.tp1.services.detailequipe;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.DetailEquipe;
import tn.esprit.tp1.repository.DetailEquipeRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class DetailEquipeServiceImpl implements IDetailEquipeService {

    private final DetailEquipeRepo detailEquipeRepo;

    @Override
    public List<DetailEquipe> listAll() {
        return null;
    }

    @Override
    public Optional<DetailEquipe> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public DetailEquipe create(DetailEquipe detailEquipe) {
        return null;
    }

    @Override
    public DetailEquipe updateOne(Long id, DetailEquipe detailEquipe) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
