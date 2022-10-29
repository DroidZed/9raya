package tn.esprit.tp1.exceptions;

import static java.text.MessageFormat.format;

public class DetailEquipeAlreadyExistsException extends RuntimeException {

    public DetailEquipeAlreadyExistsException(Integer numSalle) {
        super(format("Salle with number {0} already exists !", numSalle));
    }
}
