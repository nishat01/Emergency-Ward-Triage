package A2Q2;

/**
 *
 * @author jameselder
 */
public class BoundaryViolationException extends Exception {

    /**
     * Creates a new instance of <code>BoundaryViolationException</code> without
     * detail message.
     */
    public BoundaryViolationException() {
    }

    /**
     * Constructs an instance of <code>BoundaryViolationException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public BoundaryViolationException(String msg) {
        super(msg);
    }
}
