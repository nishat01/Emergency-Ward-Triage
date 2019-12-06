package A2Q2;

/**
 * Represent 24-hour time in hours and minutes
 * @author elder
 */
public class Time {

    int hour;
    int minute;

    public Time(int hour, int minute) throws BoundaryViolationException {
        setHour(hour);
        setMinute(minute);
    }
   
    int getHour() {
        return hour;
    }

    int getMinute() {
        return minute;
    }

    void setHour(int hour) throws BoundaryViolationException {
        if (hour < 0 || hour > 23) {
            throw new BoundaryViolationException("Hour out of range");
        } else {
            this.hour = hour;
        }
    }

    void setMinute(int minute) throws BoundaryViolationException {
        if (minute < 0 || minute > 59) {
            throw new BoundaryViolationException("Minute out of range");
        } else {
            this.minute = minute;
        }
    }
    
    /*
    Returns time elapsed  
    */
    Time elapsed(Time currentTime) throws NullPointerException, BoundaryViolationException {
       int hours, minutes;
       if (currentTime == null) {
            throw new NullPointerException();
        }
        hours = currentTime.getHour() - hour;
        minutes = currentTime.getMinute() - minute;
        if (minutes < 0) {
            hours--;
            minutes = minutes + 60;
        }
        return new Time(hours, minutes);
    }
    
    public String toString() {
        return  getHour() + ":" + getMinute();
    }
}
