import main.java.entities.Student;
import main.java.entities.teacher.Teacher;
import main.java.entities.teacher.TeacherFullTime;
import main.java.entities.teacher.TeacherPartTime;
import main.java.others.Subject;
import main.java.others.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //
        generateData();

        System.out.println("MAIN MENU");
        System.out.println("1. Print all the teachers with your information ");
        System.out.println("2. Print all the subjects ");
        System.out.println("3. Create a new student and add to exist class ");
        System.out.println("4. Create a new subject and add a exist teacher , exist students and your data");
        System.out.println("5. List all the subjects in that a student is (search by id)");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option){
            case 1:
                // Print all the teachers with your information
                System.out.println(University.teachers.toString());
                break;
            case 2:
                // Print all the subjects
                System.out.println(University.subjects.toString());
                // Later print a submenu:
                Scanner subjectNameScan = new Scanner(System.in);
                System.out.println("Enter the subject name");
                String subjectName = subjectNameScan.next();
                System.out.println("Enter the classroom number");
                scan = new Scanner(System.in);
                int classroomNumber = scan.nextInt();

                // To select a class in order to print the subject information
                Subject subject = University.getSubjectBySubjectNameAndClassroom(subjectName , classroomNumber);
                System.out.println(subject);
                // Including your teacher and students
                break;
            case 3:
                // Enter the new Student (name, id, age)
                // Enter the name
                System.out.println("Enter the name of the new student");
                scan = new Scanner(System.in);
                String nameNewStudent = scan.next();

                // Enter the id
                System.out.println("Enter the id of the new student");
                scan = new Scanner(System.in);
                int idNewStudent = scan.nextInt();

                // Enter the age
                System.out.println("Enter the age of the new student");
                scan = new Scanner(System.in);
                int ageNewStudent = scan.nextInt();

                // Enter the subject name
                Scanner subjectNameToSearchScan = new Scanner(System.in);
                System.out.println("Enter the subject name");
                String subjectNameToSearch = subjectNameToSearchScan.next();

                // Enter the classroom number
                System.out.println("Enter the classroom number");
                scan = new Scanner(System.in);
                int classroomNumberToSearch = scan.nextInt();

                // The student is created
                Student student = new Student(nameNewStudent,idNewStudent,ageNewStudent);
                // The subject is search and the student id
                Subject subjectToAddStudent = University.getSubjectBySubjectNameAndClassroom(subjectNameToSearch , classroomNumberToSearch);
                // The student is added in the university
                University.addStudent(student);
                // The student is added in a exist subject
                University.addStudentToAClass(subjectToAddStudent, student);
                // The subject later to added is printed
                System.out.println(subjectToAddStudent);
                break;
            case 4:
                // Enter the new subject name
                System.out.println("Enter the new subject name");
                scan = new Scanner(System.in);
                String nameNewSubject = scan.next();

                // Enter the new subject classroom
                System.out.println("Enter the new subject classroom");
                scan = new Scanner(System.in);
                int classroomNewSubject = scan.nextInt();

                // Enter the new subject classroom
                System.out.println("Enter the teacher id");
                scan = new Scanner(System.in);
                int idTeacherNewSubject = scan.nextInt();

                // Get teacher by id
                Teacher teacherNewSubject = University.getTeacherById(idTeacherNewSubject);

                // Create a new subject and add a exist teacher , exist students and your data
                Subject subjectToAdd = new Subject(nameNewSubject, classroomNewSubject,teacherNewSubject);

                // The new subject is added in the university subjects list
                University.addSubject(subjectToAdd);

                System.out.println(University.subjects.toString());
                break;
            case 5:
                // List all the subjects in that a student is (search by id)
                System.out.println(University.getSubjectListByStudentId(45423142).toString());
                break;
            default:

                break;
        }









    }

    public static void generateData(){

        // Group students to generates the list of students in the subjects
        List<Student> group1 = new ArrayList<>();
        List<Student> group2 = new ArrayList<>();
        List<Student> group3 = new ArrayList<>();
        List<Student> group4 = new ArrayList<>();

        //Data Student
        Student student1 = new Student("JUAN",1001250294,22);
        Student student2 = new Student("MARIA",45423142,20);
        Student student3 = new Student("CARLOS",102312304,19);
        Student student4 = new Student("ENRIQUE",122345343,24);
        Student student5 = new Student("SAMUEL",1001990294,28);
        Student student6 = new Student("ANDREA",1001450394,21);

        // adding the students in the university
        University.addStudent(student1);
        University.addStudent(student2);
        University.addStudent(student3);
        University.addStudent(student4);
        University.addStudent(student5);
        University.addStudent(student6);

        // Group 1 add students
        group1.add(student1);
        group1.add(student4);
        group1.add(student6);

        // Group 2 add students
        group2.add(student2);
        group2.add(student1);
        group2.add(student6);

        // Group 3 add students
        group3.add(student3);
        group3.add(student2);
        group3.add(student5);

        // Print the list of students in the University
        System.out.println(University.students.toString());

        // Data teachers, 2 full time y dos part time
        Teacher teacher1 = new TeacherPartTime("profe1", 1001250294,2500000, 80 );
        Teacher teacher2 = new TeacherFullTime("profe2", 45786432,3000000, 4 );
        Teacher teacher3 = new TeacherFullTime("profe3", 42445454,2300000, 2 );
        Teacher teacher4 = new TeacherPartTime("profe4", 1001450134,1600000, 80 );

        // Adding teachers in the University
        University.addTeacher(teacher1);
        University.addTeacher(teacher2);
        University.addTeacher(teacher3);
        University.addTeacher(teacher4);

        // Print the list of teachers in the University
        System.out.println(University.teachers.toString());

        // Create the subjects
        Subject subject1 = new Subject("biology", 1, teacher1, group1);
        Subject subject2 = new Subject("chemistry", 2, teacher2, group2);
        Subject subject3 = new Subject("mechanical physics", 3, teacher3, group3);
        Subject subject4 = new Subject("computing", 4, teacher4, group1);

        // Add the Subjects in the University
        University.addSubject(subject1);
        University.addSubject(subject2);
        University.addSubject(subject3);
        University.addSubject(subject4);

        //Print the list of subjects in the University
        System.out.println(University.subjects.toString());
    }
}