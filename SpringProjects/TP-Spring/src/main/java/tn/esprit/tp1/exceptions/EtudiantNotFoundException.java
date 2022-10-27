package tn.esprit.tp1.exceptions;

import java.io.Serializable;

import static java.text.MessageFormat.format;

public class EtudiantNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public EtudiantNotFoundException(Integer id) {
        super(format("Etudiant with id {0} could not be found !", id));
    }
}
