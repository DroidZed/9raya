package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tp1.entity.Universite;
import tn.esprit.tp1.services.universite.UniversiteServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/uni")
public class UniversiteController {

    private final UniversiteServiceImpl universiteService;

    @GetMapping("")
    public ResponseEntity<List<Universite>> getAll() {
        return new ResponseEntity<>(universiteService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/searchBy")
    public ResponseEntity<Universite> searchUniversityByX(@RequestParam(value = "param") String param, @RequestParam(value = "value") String value) {


    }

    private Universite searchByCriteria(String param, String value) {

        switch (param) {

            case "idUniv":
                Optional<Universite> Uopt = universiteService.findOneById(Long.valueOf(value));
                return  Uopt.orElse(new Universite());
            case "nomUniv":
                Uopt = universiteService.findOneNomUniv(String.valueOf(value));
                return Uopt.orElse(new Universite());

            default: break;
        }

        return u;
    }
}
