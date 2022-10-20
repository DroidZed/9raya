package tn.esprit.tp1.services.departement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.repository.DepartementRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements IDepartementService {

    private final DepartementRepo departementRepo;

    @Override
    public List<Departement> listAll() {
        return null;
    }

    @Override
    public Optional<Departement> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Departement create(Departement departement) {
        return null;
    }

    @Override
    public Departement updateOne(Long id, Departement departement) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
