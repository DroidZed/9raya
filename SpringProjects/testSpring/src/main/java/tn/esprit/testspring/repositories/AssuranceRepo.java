package tn.esprit.testspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.testspring.entities.Assurance;

@Repository
public interface AssuranceRepo extends JpaRepository<Assurance, Integer> {
}
