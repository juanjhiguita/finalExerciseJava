package main.java.entities.teacher;

public class TeacherFullTime extends Teacher{
    private double experience;


    public TeacherFullTime(String name, int id, double salary, long experience) {
        super(name, id, salary);
        this.experience = experience;
    }

    private double getExperience() {
        return this.experience;
    }

    private void setExperience(double experience) {
        this.experience = experience;
    }

    private double calculateSalary(){
        return (this.baseSalary * ((this.experience*110)/100));
    }

    @Override
    public String toString() {
        return super.toString() + ", experience: " + this.experience;
    }
}
