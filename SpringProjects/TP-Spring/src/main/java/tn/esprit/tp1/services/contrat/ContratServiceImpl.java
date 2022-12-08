package tn.esprit.tp1.services.contrat;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.entity.ContratGroup;
import tn.esprit.tp1.entity.Specialite;
import tn.esprit.tp1.exceptions.ContratNotFoundException;
import tn.esprit.tp1.repository.ContratRepo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {

        float ca = 0.0f;

        List<ContratGroup> group = contratRepository.groupContratsBySpecialityBetweenTowDates(startDate, endDate);

        Map<Specialite, Float> reg = new HashMap<>(4);

        reg.put(Specialite.IA, 300f);
        reg.put(Specialite.RESEAUX, 350f);
        reg.put(Specialite.CLOUD, 400f);
        reg.put(Specialite.SECURITE, 450f);

        for (ContratGroup g : group) {
            ca += reg.get(g.getSpecialite()) * g.getCount();
        }

        return ca;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.countContratsByArchiveIsFalseAndDateDebutContratBetween(startDate, endDate);
    }
}
