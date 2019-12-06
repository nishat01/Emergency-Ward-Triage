package A2Q2;

import java.util.*;

/**
 * Time-based 
 * @author elder
 */
public class PatientTimeComparator implements Comparator<Patient>{
    
    public int compare(Patient p1, Patient p2) throws NullPointerException {
        Comparator<Time> comparator = new TimeComparator();
        if (p1 == null || p2 == null) {
            throw new NullPointerException();
        }
        Time t1 = p1.getArrivalTime();
        Time t2 = p2.getArrivalTime();
        return comparator.compare(t1, t2);
    }

    public boolean equals(Patient p1, Patient p2) {
        Comparator<Time> comparator = new TimeComparator();
        if (p1 == null || p2 == null) {
            throw new NullPointerException();
        }
        Time t1 = p1.getArrivalTime();
        Time t2 = p2.getArrivalTime();
        return (comparator.compare(t1, t2) == 0);
    }

}
