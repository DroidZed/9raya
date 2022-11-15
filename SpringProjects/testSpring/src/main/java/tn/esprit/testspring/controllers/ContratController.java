package tn.esprit.testspring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.testspring.entities.Contrat;
import tn.esprit.testspring.services.contrat.ContratServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    private final ContratServiceImpl contratService;

    // create

    @PostMapping("/add")
    public ResponseEntity<?> addContrat(@RequestBody Contrat contrat) {

        Contrat c = contratService.ajouterContrat(contrat);

        return new ResponseEntity<>(c, c != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    // read

    @GetMapping
    public ResponseEntity<?> getAll() {

        return new ResponseEntity<>(contratService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneContrat(@PathVariable("id") Integer id) {

        return contratService.getById(id);
    }

    // update
    @PutMapping("/update")
    public ResponseEntity<?> updateOne(@RequestBody Contrat contrat) {

        return contratService.updateContrat(contrat);
    }

    // delete
    @DeleteMapping
    public ResponseEntity<?> deleteAll() {

        return contratService.deleteAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id") Integer id) {

        return contratService.deleteById(id);
    }

    // advanced

    @GetMapping("")
    public ResponseEntity<?> getOneByBnf(@RequestParam("idBf") int idBf) {
        Contrat c = contratService.getContratBf(idBf);

        return new ResponseEntity<>(c, c != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
