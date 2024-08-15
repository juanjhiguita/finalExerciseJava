package main.java.others;

import main.java.entities.Student;
import main.java.entities.teacher.Teacher;

import java.util.List;

public class Formatter {

    public static boolean verifySubjectNameExist(List<Subject> subjects, String subjectName){
        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyTeacherIdExist(List<Teacher> teachers, int id){
        for (Teacher teacher : teachers) {
            if (teacher.getId() == (id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyStudentIdExist(List<Student> students, int id){
        for (Student student : students) {
            if (student.getId() == (id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyClassroomExist(List<Subject> subjects, int classroom){
        for (Subject subject : subjects) {
            if (subject.getClassRoom() == (classroom)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifySubjectNameAndClassroomExist(List<Subject> subjects, String subjectName, int classroom){
        for (Subject subject : subjects) {
            if (subject.getClassRoom() == (classroom)) {
                if(subject.getName().equals(subjectName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean verifyNameMaxSize(String name){
        return name.length() < 40;
    }



    public static boolean verifyClassroomMaxSize(int classroom){
        String idStr = Integer.toString(classroom);
        return idStr.length() <= 5;
    }

    public static boolean verifyIdMaxSize(int id){
        String idStr = Integer.toString(id);
        return idStr.length() <= 10;
    }

    public static boolean verifyAgeIsPositiveAndAreInTheLimit(int age){
        return age > 0 && age < 130;
    }



}
