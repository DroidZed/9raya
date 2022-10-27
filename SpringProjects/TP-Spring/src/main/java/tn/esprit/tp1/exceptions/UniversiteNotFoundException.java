package tn.esprit.tp1.exceptions;

import static java.text.MessageFormat.format;

public class UniversiteNotFoundException extends RuntimeException {
    public UniversiteNotFoundException(Integer idUniversite) {
        super(format("University with id {0} could not be found !", idUniversite));
    }
}
