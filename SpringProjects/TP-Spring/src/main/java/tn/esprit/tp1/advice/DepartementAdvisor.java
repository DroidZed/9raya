package tn.esprit.tp1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.esprit.tp1.dto.ResponseMessage;
import tn.esprit.tp1.exceptions.DepartementNotFoundException;

@RestControllerAdvice
public class DepartementAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartementNotFoundException.class)
    public ResponseMessage departementNotFoundHandler(DepartementNotFoundException ex) {
        return new ResponseMessage(ex.getMessage());
    }
}
