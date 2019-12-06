package A2Q2;
import java.util.*;

/**
 * Priority-based comparator for Patients
 * @author elder
 */
public class PatientPriorityComparator implements Comparator<Patient>{
  
    public int compare(Patient p1, Patient p2) throws NullPointerException {
        if (p1 == null || p2 == null) {
            throw new NullPointerException();
        }
        int prior1 = p1.getPriority();
        int prior2 = p2.getPriority();
        if (prior1 < prior2) {
            return -1;
        } else if (prior1 > prior2) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Patient p1, Patient p2) throws NullPointerException {
        if (p1 == null || p2 == null) {
            throw new NullPointerException();
        }
        return p1.getPriority() == p2.getPriority();
    }
}
