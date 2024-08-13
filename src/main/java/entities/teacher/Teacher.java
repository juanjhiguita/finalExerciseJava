package main.java.entities.teacher;

import main.java.entities.Person;

public class Teacher extends Person {
    double salary;

    public Teacher(String name, int id, double salary, long experience) {
        super(name, id);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
