package main.java.entities;

public class Student extends Person {
    private int age;

    public Student(String name, int id, int age) {
        super(name, id);
        this.age = age;
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

    private int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "The student name is: " + this.name + ", with id: " + this.id + " and age: " + this.age;
    }

}
