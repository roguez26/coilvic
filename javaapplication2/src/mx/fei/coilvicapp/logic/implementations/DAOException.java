package mx.fei.coilvicapp.logic.implementations;

/**
 *
 * @author ivanr
 */
public class DAOException extends Exception {
    private final Status status;

    public DAOException(String message, Status status) {
        super(message);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
