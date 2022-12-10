package tn.esprit.testspring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.testspring.entities.Assurance;
import tn.esprit.testspring.services.assurance.AssuranceService;

@RestController
@AllArgsConstructor
@RequestMapping("/assurance")
public class AssuranceController {

    private final AssuranceService assuranceService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(assuranceService.getAllAssurances(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Assurance assurance,
                                    @RequestParam("cin") int cinBf,
                                    @RequestParam("matricule") String matricule) {

        Assurance a = assuranceService.ajouterAssurance(assurance, cinBf, matricule);

        return new ResponseEntity<>(a, a != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
}
