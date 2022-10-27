package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1.entity.Equipe;
import tn.esprit.tp1.services.equipe.EquipeServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeServiceImpl equipeService;

    @GetMapping("")
    public ResponseEntity<?> getAllEquipes() {
        return new ResponseEntity<>(equipeService.retrieveAllEquipes(), HttpStatus.OK);
    }

    @PostMapping("/addEquipe")
    public ResponseEntity<?> addEquipe(@RequestBody Equipe e) {

        Equipe equipe = equipeService.addEquipe(e);

        return new ResponseEntity<>(equipe, equipe != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
}
