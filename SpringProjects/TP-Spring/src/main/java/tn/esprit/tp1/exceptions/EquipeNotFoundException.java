package tn.esprit.tp1.exceptions;

import static java.text.MessageFormat.format;

public class EquipeNotFoundException extends RuntimeException {
    public EquipeNotFoundException(Integer idEquipe) {
        super(format("Equipe with id {0} could not be found !", idEquipe));
    }
}
