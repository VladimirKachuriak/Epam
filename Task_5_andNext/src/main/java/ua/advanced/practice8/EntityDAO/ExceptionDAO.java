package ua.advanced.practice8.EntityDAO;

public class ExceptionDAO extends RuntimeException {
    public ExceptionDAO() {
        super();
    }

    public ExceptionDAO(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDAO(String message) {
        super(message);
    }
}
