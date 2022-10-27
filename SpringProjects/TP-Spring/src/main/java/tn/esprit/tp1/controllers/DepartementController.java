package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tp1.entity.Departement;
import tn.esprit.tp1.services.departement.DepartementServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/departement")
public class DepartementController {

    private final DepartementServiceImpl departementService;

    @PostMapping("/add")
    public ResponseEntity<?> addDepartement(@RequestBody Departement departement) {

        Departement d = departementService.addDepartement(departement);

        return new ResponseEntity<>(d, d != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
}
