package A2Q2;

/**
 *
 * @author elder
 */
public class EmptyQueueException extends Exception {

    /**
     * Creates a new instance of <code>EmptyQueueException</code> without detail
     * message.
     */
    public EmptyQueueException() {
    }

    /**
     * Constructs an instance of <code>EmptyQueueException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyQueueException(String msg) {
        super(msg);
    }
}
