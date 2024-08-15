package main.java.entities.teacher;

public class TeacherFullTime extends Teacher{
    private float experience;

    public TeacherFullTime(String name, int id, double salary, long experience) {
        super(name, id, salary);
        this.experience = experience;
    }

    private float getExperience() {
        return this.experience;
    }

    private void setExperience(float experience) {
        this.experience = experience;
    }

    @Override
    public void calculateSalary(){
        super.setSalary((this.baseSalary * 110)/100);
    }

    @Override
    public String toString() {
        return super.toString() + ", experience: " + this.experience + " years";
    }

}
