package calculatrice;

public class ChaineInvalideException extends RuntimeException {
    ChaineInvalideException(String message) {
        super(message);
    }

    public ChaineInvalideException() {
        super();
    }
}
