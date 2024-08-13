import main.java.entities.Student;
import main.java.entities.teacher.Teacher;
import main.java.entities.teacher.TeacherFullTime;
import main.java.entities.teacher.TeacherPartTime;
import main.java.others.Subject;
import main.java.others.University;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("JUAN",1001250294,22);
        Student student2 = new Student("MARIA",4564444,22);
        Student student3 = new Student("CARLOS",102312304,22);
        Student student4 = new Student("ALBEIRO",45682322,22);

        University.addStudents(student1);
        University.addStudents(student2);
        University.addStudents(student3);
        University.addStudents(student4);

        System.out.println(University.students.toString());

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println(students);

        Teacher teacher1 = new TeacherPartTime("profe1", 1001250294,1000000, 80 );
        Teacher teacher2 = new TeacherPartTime("profe2", 1001250294,1000000, 80 );
        Teacher teacher3 = new TeacherFullTime("profe3", 1001250294,1000000, 2 );
        Teacher teacher4 = new TeacherPartTime("profe4", 1001250294,1000000, 80 );

        University.addTeacher(teacher1);
        University.addTeacher(teacher2);
        University.addTeacher(teacher3);
        University.addTeacher(teacher4);

        System.out.println(University.teachers.toString());

        Subject clase1 = new Subject("matematicas", 1, teacher1, students);
        Subject clase2 = new Subject("sociales", 2, teacher2);
        Subject clase3 = new Subject("filosofia", 3, teacher3, students);

        University.addClass(clase1);
        University.addClass(clase2);
        University.addClass(clase3);

        System.out.println(University.subjects.toString());

        University.addStudentToAClass(clase2, student4);

        System.out.println(University.subjects.toString());

    }
}