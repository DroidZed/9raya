package tn.esprit.testspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.testspring.entities.Contrat;

@Repository
public interface ContratRepo extends JpaRepository<Contrat, Integer> {
}
