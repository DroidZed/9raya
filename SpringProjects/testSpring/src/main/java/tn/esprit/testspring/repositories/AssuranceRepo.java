package tn.esprit.testspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.testspring.entities.Assurance;
import tn.esprit.testspring.entities.GroupMontantTypeContrat;

import java.util.List;

@Repository
public interface AssuranceRepo extends JpaRepository<Assurance, Integer> {

    @Query("SELECT a.montant, c.typeContrat from Beneficiaire b Join Assurance a Join Contrat c Where b.cin = ?1 group by c.typeContrat")
    List<GroupMontantTypeContrat> groupAssurancesByMontantAndTypeContrat(Integer cin);
}
