package tn.esprit.tp1.services.etudiant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.repository.EtudiantRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;

    @Override
    public List<Etudiant> listAll() {
        return null;
    }

    @Override
    public Optional<Etudiant> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Etudiant create(Etudiant etudiant) {
        return null;
    }

    @Override
    public Etudiant updateOne(Long id, Etudiant etudiant) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
