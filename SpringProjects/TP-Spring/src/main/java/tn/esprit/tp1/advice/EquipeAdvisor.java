package tn.esprit.tp1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tn.esprit.tp1.dto.ResponseMessage;
import tn.esprit.tp1.exceptions.DetailEquipeAlreadyExistsException;
import tn.esprit.tp1.exceptions.EquipeNotFoundException;

@RestControllerAdvice
public class EquipeAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EquipeNotFoundException.class)
    public ResponseMessage equipeNotFoundHandler(EquipeNotFoundException ex) {
        return new ResponseMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DetailEquipeAlreadyExistsException.class)
    public ResponseMessage detailEquipeFoundHandler(DetailEquipeAlreadyExistsException ex) {
        return new ResponseMessage(ex.getMessage());
    }
}
