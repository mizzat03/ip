public class LennyExceptions extends Exception {
    // Default constructor
    public LennyExceptions() {
        super();
    }

    // Constructor that accepts a message
    public LennyExceptions(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public LennyExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public LennyExceptions(Throwable cause) {
        super(cause);
    }
}
