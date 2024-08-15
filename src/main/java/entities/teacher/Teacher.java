package main.java.entities.teacher;

import main.java.entities.Person;

public abstract class Teacher extends Person {
    protected double baseSalary;
    private double salary;

    public Teacher(String name, int id, double baseSalary) {
        super(name, id);
        this.baseSalary = baseSalary;
    }

    public String getName(){
        return super.name;
    }

    public void setName(String name){
        super.name = name;
    }

    public int getId(){
        return super.id;
    }

    protected void setId(int id){
        super.id = id;
    }

    protected double getBaseSalary() {
        return baseSalary;
    }

    protected void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    protected double getSalary() {
        return salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    public void calculateSalary(){};

    @Override
    public String toString() {
        return "The teacher name is: " + this.name + ", with id: " + this.id + " and baseSalary: " + this.baseSalary;
    }
}
