package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Option;
import tn.esprit.tp1.entity.Specialite;
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

    @GetMapping("/list/options")
    public ResponseEntity<?> groupAllByOption() {
        return new ResponseEntity<>(etudiantService.listEtudiantsParOption(), HttpStatus.OK);
    }

    @GetMapping("/count/students/options")
    public ResponseEntity<?> countNumberOfStudentsByOption(@RequestParam("option") Option o) {
        return new ResponseEntity<>(etudiantService.countStudentsByOption(o), HttpStatus.OK);
    }

    @GetMapping("/count/students/specialite")
    public ResponseEntity<?> countNumberOfStudentsBySpecialite(@RequestParam("specialite") Specialite s) {
        return new ResponseEntity<>(etudiantService.countEtudiantsParSpecialite(s), HttpStatus.OK);
    }
}
