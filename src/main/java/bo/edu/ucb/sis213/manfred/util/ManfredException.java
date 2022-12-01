package bo.edu.ucb.sis213.manfred.util;

public class ManfredException extends RuntimeException {
    public ManfredException(String message) {
        super(message);
    }

    public ManfredException(String message, Throwable cause) {
        super(message, cause);
    }
}

