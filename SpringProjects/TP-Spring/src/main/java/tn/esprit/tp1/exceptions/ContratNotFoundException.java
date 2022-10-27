package tn.esprit.tp1.exceptions;


import java.io.Serializable;

import static java.text.MessageFormat.format;


public class ContratNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ContratNotFoundException(Integer id) {
        super(format("Contrat with id {0} could not be found !", id));
    }


}
