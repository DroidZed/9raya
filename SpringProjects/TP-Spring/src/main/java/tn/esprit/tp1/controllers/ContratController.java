package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tp1.services.contrat.ContratServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    private final ContratServiceImpl contratService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(contratService.retrieveAllContrats(), HttpStatus.OK);
    }



}
