package main.java.entities.teacher;

public class TeacherPartTime extends Teacher{
    private float workingHours;

    public TeacherPartTime(String name, int id, double baseSalary, float workingHours) {
        super(name, id, baseSalary);
        this.workingHours = workingHours;
    }

    @Override
    public  void calculateSalary(){
        super.setSalary(this.baseSalary * this.workingHours);
    }

    private float getWorkingHours() {
        return workingHours;
    }

    private void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return super.toString() + ", working: " + this.workingHours + " hours";
    }
}
