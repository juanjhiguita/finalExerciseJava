package main.java.others;

import main.java.entities.Student;
import main.java.entities.teacher.Teacher;
import main.java.others.Class;

import java.util.ArrayList;
import java.util.List;

public class University {
    public static List<Student> students = new ArrayList<>();
    public static List<Class> classes = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();

    public static void addClass(Class classToAdd){
        classes.add(classToAdd);
    }

    public static void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public static void addStudents(Student student){
        students.add(student);
    }

    public static void addStudentToAClass(Class classToAsign, Student student){
        if(classes.contains(classToAsign)){
            int index = classes.indexOf(classToAsign);
            classes.get(index).addStudent(student);
        }
    }



}
