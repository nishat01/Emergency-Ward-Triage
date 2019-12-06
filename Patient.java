package A2Q2;

import java.util.*;

/**
 * A location-aware patient record, representing 1) a patient ID, priority and
 * arrival time. ID and priority must be positive integers.
 * Also represented are integer locations in priority and arrival time queues.
 *
 * @author elder
 */
public class Patient {

    private int id;
    private int priority;
    private Time arrivalTime;
    private int priorityPos;
    private int timePos;

    /**
     * Constructor
     *
     * @param patientID
     * @param patientPriority
     * @param arrivalTime
     * @throws NullPointerException if arrivalTime is null
     * @throws BoundaryViolationException if patientID or patientPriority are out of range
      */
    public Patient(int patientID, int patientPriority, Time time) throws NullPointerException, BoundaryViolationException {
        setID(patientID);
        setPriority(patientPriority);
        setArrivalTime(time);
    }

    public int getID() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getPriorityPos() {
        return priorityPos;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public int getTimePos() {
        return timePos;
    }

    /**
     * @param id
     * @throws BoundaryViolationException if id is out of range
     */
    public void setID(int id) throws BoundaryViolationException {
        if (id < 1) {
            throw new BoundaryViolationException();
        }
        this.id = id;
    }

    /**
     * @param priority
     * @throws BoundaryViolationException if priority is out of range
     */
     public void setPriority(int priority) throws BoundaryViolationException {
        if (priority < 1) {
            throw new BoundaryViolationException();
        }
      this.priority = priority;
    }

    /**
     * @param pos
     */
    public void setPriorityPos(int pos) {
        this.priorityPos = pos;
    }

    /**
     * @param time
     * @throws NullPointerException if time is null
     */
    public void setArrivalTime(Time time) throws NullPointerException {
        if (time == null) {
            throw new NullPointerException();
        }
        arrivalTime = time;
    }

    /**
     * @param pos
     */
    public void setTimePos(int pos) {
        this.timePos = pos;

    }

    public String toString() {
        return "Patient ID: " + getID() + " Priority: " + getPriority()
                + " Arrival Time: " + getArrivalTime().toString();
    }
}
