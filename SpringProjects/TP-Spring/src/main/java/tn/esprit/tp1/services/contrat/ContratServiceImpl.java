package tn.esprit.tp1.services.contrat;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.exceptions.ContratNotFoundException;
import tn.esprit.tp1.repository.ContratRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepo contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {

        return contratRepository.findAll();
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElseThrow(() -> new ContratNotFoundException(idContrat));
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {

        return contratRepository.findById(contrat.getIdContrat())
                .map(ctr -> {

                    contrat.setDateFinContrat(ctr.getDateFinContrat());
                    contrat.setSpecialite(ctr.getSpecialite());
                    contrat.setDateDebutContrat(ctr.getDateDebutContrat());

                    return contratRepository.save(contrat);

                }).orElseThrow(() -> new ContratNotFoundException(contrat.getIdContrat()));
    }

    @Override
    public void removeContrat(Integer idContrat) {

        if (!contratRepository.existsById(idContrat))
            throw new ContratNotFoundException(idContrat);

        else
            contratRepository.deleteById(idContrat);
    }
}
