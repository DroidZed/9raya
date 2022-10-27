package tn.esprit.tp1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.esprit.tp1.dto.ResponseMessage;
import tn.esprit.tp1.exceptions.ContratNotFoundException;

@RestControllerAdvice
public class ContratAdvisor {

    @ExceptionHandler(ContratNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMessage contratNotFoundHandle(ContratNotFoundException ex) {
        return new ResponseMessage(ex.getMessage());
    }
}
