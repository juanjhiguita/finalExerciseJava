package main.java.entities;

public class Student extends Person {
    private int age;

    public Student(String name, int id, int age) {
        super(name, id);
        this.age = age;
    }

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }


}
