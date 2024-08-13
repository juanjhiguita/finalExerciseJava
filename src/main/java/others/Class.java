package main.java.others;

import main.java.entities.Student;
import main.java.entities.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private int classRoom;
    private Teacher teacher;
    private List<Student> studentList;

    public Class(String name, int classRoom, Teacher teacher) {
        this.name = name;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.studentList = new ArrayList<>();
    }

    public Class(String name, int classRoom, Teacher teacher, List<Student> students) {
        this.name = name;
        this.classRoom = classRoom;
        this.studentList = students;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberClassroom() {
        return this.classRoom;
    }

    public void setNumberClassroom(int classRoom) {
        this.classRoom = classRoom;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    @Override
    public String toString() {
        return "Name class: " + this.name + " classroom: " + this.classRoom + ", Students" + studentList.toString();
    }
}
