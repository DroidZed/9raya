package tn.esprit.tp1.advisors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tn.esprit.tp1.exceptions.ContratNotFoundException;

@ControllerAdvice
public class ContratNotFoundAdvisor {

    @ResponseBody
    @ExceptionHandler(ContratNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String contratNotFoundHandle(ContratNotFoundException ex) {
        return ex.getMessage();
    }
}
