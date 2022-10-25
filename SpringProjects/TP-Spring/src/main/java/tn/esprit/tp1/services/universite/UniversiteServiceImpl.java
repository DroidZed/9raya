package tn.esprit.tp1.services.universite;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Universite;
import tn.esprit.tp1.repository.UniversiteRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepo universiteRepo;

    @Override
    public List<Universite> listAll() {
        return universiteRepo.findAll();
    }

    @Override
    public Optional<Universite> findOneById(Long id) {
        return universiteRepo.findById(id);
    }

    @Override
    public Universite create(Universite universite) {
        return universiteRepo.save(universite);
    }

    @Override
    public Universite updateOne(Long id, Universite universite) {
        return null;
    }



    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    public Optional<Universite> findOneNomUniv(String nomUniv) {return universiteRepo.findByNomUniv(nomUniv);}
}
