package main.java.entities.teacher;

public class TeacherPartTime extends Teacher{
    long workingHours;

    public TeacherPartTime(String name, int id, double salary, long experience, long workingHours) {
        super(name, id, salary, experience);
        this.workingHours = workingHours;
    }

    public long getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(long workingHours) {
        this.workingHours = workingHours;
    }
}
