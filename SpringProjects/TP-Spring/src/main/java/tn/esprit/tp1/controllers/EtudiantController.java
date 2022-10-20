package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tp1.services.etudiant.EtudiantServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantServiceImpl etudiantService;

    @GetMapping("/")
    public ResponseEntity<?> readAll() {

        return new ResponseEntity<>(etudiantService.listAll(), HttpStatus.OK);
    }
}
