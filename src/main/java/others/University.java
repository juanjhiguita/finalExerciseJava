package main.java.others;

import main.java.entities.Student;
import main.java.entities.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University{
    public static List<Student> students = new ArrayList<>();
    public static List<Subject> subjects = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();

    public static void addSubject(Subject subjectToAdd){
        subjects.add(subjectToAdd);
    }

    public static void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public static void addStudent(Student student){
        students.add(student);
    }

    public static void addStudentToAClass(Subject subject, Student student){
        if(subjects.contains(subject)){
            int index = subjects.indexOf(subject);
            subjects.get(index).addStudent(student);
        }
    }

    public static Subject getSubjectBySubjectNameAndClassroom(String subjectName, int classroom){
        Subject subjectFinded = null;
        for (Subject subject : subjects) {
            if (subject.getClassRoom() == classroom && subject.getName().equals(subjectName)) {
                subjectFinded = subject;
            }
        }
        return subjectFinded;
    }

    public static Teacher getTeacherById(int idTeacher){
        Teacher teacherFinded = null;
        for (Teacher teacher : teachers) {
            if (teacher.getId() == idTeacher) {
                teacherFinded = teacher;
            }
        }
        return teacherFinded;
    }

    public static List<Subject> getSubjectListByStudentId(int idStudent){
        List<Subject> subjectsByStudentId = new ArrayList<>();
        for (Subject subject : subjects) {
            if(subject.isASubjectStudent(idStudent)){
                subjectsByStudentId.add(subject);
            }
        }
        return subjectsByStudentId;
    }

}
