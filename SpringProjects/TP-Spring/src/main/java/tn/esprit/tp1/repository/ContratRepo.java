package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1.entity.Contrat;
import tn.esprit.tp1.entity.ContratGroup;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepo extends JpaRepository<Contrat, Integer> {

    Integer countContratsByArchiveIsFalseAndDateDebutContratBetween(Date dateD, Date dateF);

    @Query("SELECT count (c) as count, c.specialite as specialite from Contrat c where c.dateDebutContrat = ?1 and c.dateFinContrat = ?2 and c.archive = false group by c.specialite")
    List<ContratGroup> groupContratsBySpecialityBetweenTowDates(Date dateDebutContrat, Date dateFinContrat);
}
