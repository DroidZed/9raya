package tn.esprit.tp1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.esprit.tp1.dto.ResponseMessage;
import tn.esprit.tp1.exceptions.UniversiteNotFoundException;

@RestControllerAdvice
public class UniversiteAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UniversiteNotFoundException.class)
    public ResponseMessage universiteNotFoundHandle(UniversiteNotFoundException ex) {
        return new ResponseMessage(ex.getMessage());
    }
}
