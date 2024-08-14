package main.java.entities.teacher;

import main.java.entities.Person;

public class Teacher extends Person {
    protected double baseSalary;

    public Teacher(String name, int id, double baseSalary) {
        super(name, id);
        this.baseSalary = baseSalary;
    }

    protected double getBaseSalary() {
        return baseSalary;
    }

    protected void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return super.toString() + ", salary: " + this.baseSalary;
    }
}
