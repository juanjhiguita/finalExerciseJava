package main.java.entities.teacher;

public class TeacherPartTime extends Teacher{
    long workingHours;

    public TeacherPartTime(String name, int id, double salary, long workingHours) {
        super(name, id, salary);
        this.workingHours = workingHours;
    }

    public long getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(long workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", working: " + this.workingHours + " hours";
    }
}
