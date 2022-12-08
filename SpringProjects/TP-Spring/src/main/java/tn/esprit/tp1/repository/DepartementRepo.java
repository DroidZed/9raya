package tn.esprit.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp1.entity.Departement;

import java.util.List;

@Repository
public interface DepartementRepo extends JpaRepository<Departement, Integer> {

}
