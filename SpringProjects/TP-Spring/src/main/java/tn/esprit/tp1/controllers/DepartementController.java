package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("")
    public ResponseEntity<?> getAllDepts() {
        return new ResponseEntity<>(departementService.retrieveAllDepartements(), HttpStatus.OK);
    }

    @PutMapping("/updateDept")
    public ResponseEntity<?> updateDepartement(@RequestBody Departement departement) {
        Departement d = departementService.updateDepartement(departement);

        return new ResponseEntity<>(d, d != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getByUniversite(@RequestParam("idU") Integer idU) {

        return new ResponseEntity<>(departementService.retrieveDepartementsByUniversite(idU), HttpStatus.OK);
    }
}
