package exception;

public class ApplicationDeadlinePassedException extends Exception {
    public ApplicationDeadlinePassedException(String message) {
        super(message);
    }
}

