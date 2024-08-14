package main.java.entities.teacher;

public class TeacherPartTime extends Teacher{
    private double workingHours;

    public TeacherPartTime(String name, int id, double baseSalary, double workingHours) {
        super(name, id, baseSalary);
        this.workingHours = workingHours;
    }

    private double getWorkingHours() {
        return workingHours;
    }

    private double calculateSalary(){
        return (this.baseSalary * this.workingHours);
    }

    private void setWorkingHours(long workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", working: " + this.workingHours + " hours";
    }
}
