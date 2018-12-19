package exception;

/**
 * This exception is thrown whenever an action is performed but without any
 * results.
 *
 */
public class NoResultException extends RuntimeException {
    public NoResultException(String msg) {
        super(msg);
    }
}
