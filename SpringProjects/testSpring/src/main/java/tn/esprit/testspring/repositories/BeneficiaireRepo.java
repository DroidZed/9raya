package tn.esprit.testspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.testspring.entities.Beneficiaire;

@Repository
public interface BeneficiaireRepo extends JpaRepository<Beneficiaire, Integer> {

    Beneficiaire findBeneficiaireByCin(Integer cin);
}
