package A2Q2;
import java.util.*;

/**
 * Comparator for Time
 * @author elder
 */
public class TimeComparator implements Comparator<Time> {
    public int compare(Time t1, Time t2)  throws NullPointerException {
        if (t1 == null || t2 == null) {
            throw new NullPointerException();
        }
        
        if (t1.getHour() == t2.getHour()) {
            if (t1.getMinute() < t2.getMinute()) {
                return -1;
            }
            else if (t1.getMinute() == t2.getMinute()) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else if (t1.getHour() < t2.getHour()) {
            return -1;
        }
        else {
            return 1;
        }
    }
    
    public boolean equals(Patient p1, Patient p2) {
        if (p1 == null || p2 == null) {
            throw new NullPointerException();
        }
        return p1.getPriority() == p2.getPriority();
    }

}
