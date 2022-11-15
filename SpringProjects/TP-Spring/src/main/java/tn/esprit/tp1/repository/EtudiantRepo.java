package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.entity.Option;

import java.util.List;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {

    Etudiant findByNomAndPrenom(String nom, String prenom);

    List<Etudiant> findAllByDepartement(Departement departement);
}
