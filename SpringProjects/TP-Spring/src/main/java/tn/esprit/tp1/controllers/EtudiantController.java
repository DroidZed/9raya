package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.services.etudiant.EtudiantServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantServiceImpl etudiantService;

    @DeleteMapping("/{id}")
    public void deleteOnById(@PathVariable(value = "id") Integer id) {

        etudiantService.removeEtudiant(id);
    }

    @PatchMapping("/assignEtudToDepart")
    public void assignEtudToDepart(@RequestParam(value = "idEtud") Integer idEtud, @RequestParam(value = "idDepart") Integer idDepart) {

        etudiantService.assignEtudiantToDepartement(idEtud, idDepart);
    }
}
