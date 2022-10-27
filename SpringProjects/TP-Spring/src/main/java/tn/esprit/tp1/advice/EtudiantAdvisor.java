package tn.esprit.tp1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.esprit.tp1.dto.ResponseMessage;
import tn.esprit.tp1.exceptions.EtudiantNotFoundException;

@RestControllerAdvice
public class EtudiantAdvisor {

    @ExceptionHandler(EtudiantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMessage contratNotFoundHandle(EtudiantNotFoundException ex) {
        return new ResponseMessage(ex.getMessage());
    }
}
