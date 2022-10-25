package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1.entity.Universite;

import java.util.Optional;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long> {

    Optional<Universite> findByNomUniv(String nomUniv);
}
