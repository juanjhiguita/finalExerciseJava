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


}
