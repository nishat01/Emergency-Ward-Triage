package A2Q2;

/**
 * Interface for locating location-aware entries with integer locations.
 * @author elder
 */
public interface Locator<E> {    
    public int get(E e);
    public void set (E e, int pos);
}
