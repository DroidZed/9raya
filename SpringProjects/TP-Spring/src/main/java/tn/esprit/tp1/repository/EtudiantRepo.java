package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.entity.Etudiant;
import tn.esprit.tp1.entity.Option;
import tn.esprit.tp1.entity.Specialite;

import java.util.List;
import java.util.Map;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {

    Etudiant findByNomAndPrenom(String nom, String prenom);

    List<Etudiant> findAllByDepartement(Departement departement);

    Integer countEtudiantsByOption(Option option);

    @Query(value = "SELECT COUNT(*) FROM Etudiant e JOIN Contrat c WHERE c.specialite = :s", nativeQuery = true)
    Integer countEtudiantsBySpecialite(Specialite s);

    @Query("SELECT e From Etudiant e Join Contrat c group by c.specialite")
    Map<Specialite, List<Etudiant>> groupEtudiantsBySpecialite();
}
