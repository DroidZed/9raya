package tn.esprit.testspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.testspring.entities.Beneficiaire;

import java.util.Optional;
import java.util.TreeMap;

@Repository
public interface BeneficiaireRepo extends JpaRepository<Beneficiaire, Integer> {

    Optional<Beneficiaire> findBeneficiaireByCin(Integer cin);

    Optional<Beneficiaire> findByCin(int cinBf);

    @Query("SELECT Count(a), b.cin from Beneficiaire b Join Assurance a group by b.cin")
    TreeMap<Integer, Integer> getNumberOfAssurancesByCin();
}
