package A2Q2;

/**
 * Example test program for PatientTriage
 * @author elder
 */
public class testPatientTriage {
    public static void main(String[] args) throws BoundaryViolationException, EmptyQueueException {
        String patient;
        
        PatientTriage patientTriage = new PatientTriage(new Time (3, 0)); //Time limit of 3 hours
        patientTriage.add(new Patient(1, 4, new Time (0, 30)));
        patientTriage.add(new Patient(2, 3, new Time (1, 45)));
        patientTriage.add(new Patient(3, 2, new Time (2, 45)));
        patient = patientTriage.remove(new Time (3, 0)).toString(); 
        System.out.print("Now seeing: ");
        System.out.println(patient); //Should be patient 3
        patient = patientTriage.remove(new Time (4, 15)).toString();
        System.out.print("Now seeing: "); //Should be patient 1
        System.out.println(patient);
        patient = patientTriage.remove(new Time (4, 30)).toString();
        System.out.print("Now seeing: "); //Should be patient 2
        System.out.println(patient);


    }
    
}
