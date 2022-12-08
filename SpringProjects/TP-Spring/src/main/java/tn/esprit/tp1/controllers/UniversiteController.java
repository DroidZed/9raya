package tn.esprit.tp1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tp1.services.universite.UniversiteServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    private final UniversiteServiceImpl universiteService;
}
