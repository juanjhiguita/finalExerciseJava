package main.java.entities.teacher;

import main.java.entities.Person;

public class Teacher extends Person {
    protected double baseSalary;

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

    public void setId(int id){
        super.id = id;
    }

    protected double getBaseSalary() {
        return baseSalary;
    }

    protected void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "The teacher name is: " + this.name + ", with id: " + this.id + ", baseSalary: " + this.baseSalary;
    }
}
