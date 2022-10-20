package tn.esprit.tp1.services.contrat;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.exceptions.ContratNotFoundException;
import tn.esprit.tp1.repository.ContratRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepo contratRepository;

    @Override
    public List<Contrat> listAll() {
        List<Contrat> list = contratRepository.findAll();

        list.forEach(contrat -> log.info("Contrat: " + contrat.toString()));

        return list;
    }

    @Override
    public Optional<Contrat> findOneById(Long id) {
        return contratRepository.findById(id);
    }

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateOne(Long id, Contrat newContrat) {

        return contratRepository.findById(id)
                .map(contrat -> {

                    contrat.setDateFinContrat(newContrat.getDateFinContrat());
                    contrat.setArchive(newContrat.getArchive());
                    contrat.setSpecialite(newContrat.getSpecialite());

                    return contratRepository.save(contrat);

                }).orElseThrow(() -> new ContratNotFoundException(id));
    }

    @Override
    public void deleteOne(Long id) {

        Optional<Contrat> c = contratRepository.findById(id);

        if (!c.isPresent())
            throw new ContratNotFoundException(id);

        else
            contratRepository.delete(c.get());
    }

    @Override
    public void deleteAll() {
        contratRepository.deleteAll();
    }
}
