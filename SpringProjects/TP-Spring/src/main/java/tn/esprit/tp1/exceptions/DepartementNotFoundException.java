package tn.esprit.tp1.exceptions;

import java.io.Serializable;

import static java.text.MessageFormat.format;

public class DepartementNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public DepartementNotFoundException(Integer id) {
        super(format("Departement with id {0} could not be found !", id));
    }
}
