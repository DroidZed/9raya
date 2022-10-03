package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1.entity.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {
}
