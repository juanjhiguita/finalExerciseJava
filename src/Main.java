import main.java.entities.Student;
import main.java.entities.teacher.Teacher;
import main.java.entities.teacher.TeacherFullTime;
import main.java.entities.teacher.TeacherPartTime;
import main.java.others.Formatter;
import main.java.others.Subject;
import main.java.others.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //
        boolean exit = false;
        generateData();
        while (!exit){
            System.out.println("MAIN MENU");
            System.out.println("0. Exit ");
            System.out.println("1. Print all the teachers with your information ");
            System.out.println("2. Print all the subjects ");
            System.out.println("3. Create a new student and add to exist class ");
            System.out.println("4. Create a new subject and add a exist teacher , exist students and your data");
            System.out.println("5. List all the subjects in that a student is (search by id)");
            Scanner scan = new Scanner(System.in);
            try{
                int option = scan.nextInt();
                switch (option){
                    case 0:
                        // Exit case
                        exit = true;
                        break;
                    case 1:
                        // Print all the teachers with your information
                        System.out.println(University.generateStringTeachers());
                        break;
                    case 2:
                        // Print all the subjects
                        System.out.println(University.generateStringSubjects());
                        // Later print a submenu:
                        Scanner subjectNameScan = new Scanner(System.in);
                        System.out.println("Enter the subject name");
                        String subjectName = subjectNameScan.next();
                        System.out.println("Enter the classroom number");
                        scan = new Scanner(System.in);
                        try{
                            int classroomNumber = scan.nextInt();
                            boolean result = Formatter.verifySubjectNameAndClassroomExist(University.subjects,subjectName, classroomNumber );
                            if(result){
                                // To select a class in order to print the subject information
                                Subject subject = University.getSubjectBySubjectNameAndClassroom(subjectName , classroomNumber);
                                System.out.println("The specific information about the select subject");
                                System.out.println(subject);
                            }else {
                                System.out.println("The Subject (name: " + subjectName + ", classroom: " + classroomNumber + ") don't exist");
                            }
                        }catch (Exception NumberFormatException){
                            System.out.println("Enter a valid classroom number (int)");
                        }
                        break;
                    case 3:
                        // Enter the new Student (name, id, age)
                        // Enter the name
                        System.out.println("Enter the name of the new student");
                        scan = new Scanner(System.in);
                        String nameNewStudent = scan.next();

                        if(!Formatter.verifyNameMaxSize(nameNewStudent)){
                            System.out.println("The name size field < 40");
                            break;
                        }

                        // Enter the id
                        try{
                            System.out.println("Enter the id of the new student");
                            scan = new Scanner(System.in);
                            int idNewStudent = scan.nextInt();

                            // Enter the age
                            System.out.println("Enter the age of the new student");
                            scan = new Scanner(System.in);
                            int ageNewStudent = scan.nextInt();

                            if(!Formatter.verifyAgeIsPositiveAndAreInTheLimit(ageNewStudent)){
                                System.out.println("The age should be 0 < age < 130");
                                break;
                            }

                            // Enter the subject name
                            Scanner subjectNameToSearchScan = new Scanner(System.in);
                            System.out.println("Enter the subject name");
                            String subjectNameToSearch = subjectNameToSearchScan.next();

                            if(!Formatter.verifyNameMaxSize(subjectNameToSearch)){
                                System.out.println("The max characters in the name are 40");
                                break;
                            }

                            // Enter the classroom number
                            System.out.println("Enter the classroom number");
                            scan = new Scanner(System.in);
                            int classroomNumberToSearch = scan.nextInt();

                            if(!Formatter.verifyClassroomMaxSize(classroomNumberToSearch)){
                                System.out.println("The max characters in the classroomNumber are 5");
                                break;
                            }

                            if(Formatter.verifySubjectNameAndClassroomExist(University.subjects,subjectNameToSearch, classroomNumberToSearch)){
                                // The student is created
                                Student student = new Student(nameNewStudent,idNewStudent,ageNewStudent);
                                // The subject is search and the student id
                                Subject subjectToAddStudent = University.getSubjectBySubjectNameAndClassroom(subjectNameToSearch , classroomNumberToSearch);
                                // The student is added in the university
                                University.addStudent(student);
                                // The student is added in exist subject
                                University.addStudentToAClass(subjectToAddStudent, student);
                                // The subject later to added is printed
                                System.out.println(student);
                                System.out.println("Was added to the next Subject: ");
                                System.out.println(subjectToAddStudent);
                                break;
                            }else{
                                System.out.println("The subject (subjectName, classroom) don't exist");
                            }
                            break;
                        }catch (Exception NumberFormatException){
                            System.out.println("Input a valid option (integer)");
                        }
                        break;
                    case 4:
                        // Enter the new subject name
                        System.out.println("Enter the new subject name");
                        scan = new Scanner(System.in);
                        String nameNewSubject = scan.next();

                        if(!Formatter.verifyNameMaxSize(nameNewSubject)){
                            System.out.println("The max characters in the name are 40");
                            break;
                        }
                        // Enter exist classroom to the new subject
                        System.out.println("Enter a classroom to the new subject");
                        scan = new Scanner(System.in);
                        int classroomNewSubject = scan.nextInt();

                        if(!Formatter.verifyClassroomMaxSize(classroomNewSubject)){
                            System.out.println("The max characters in the classroomNumber are 5");
                            break;
                        }

                        // Enter the new subject classroom
                        System.out.println("Enter the teacher id");
                        scan = new Scanner(System.in);
                        int idTeacherNewSubject = scan.nextInt();

                        if(!Formatter.verifyIdMaxSize(idTeacherNewSubject)){
                            System.out.println("The teacher id should be id < 10");
                            break;
                        }

                        if(Formatter.verifyTeacherIdExist(University.teachers,idTeacherNewSubject)){
                            // Get teacher by id
                            Teacher teacherNewSubject = University.getTeacherById(idTeacherNewSubject);

                            // Creation of a random group of students
                            List<Student> randomStudentGroup = createRandomListWithStudents(University.students, 3);
                            System.out.println("The list of students was generate randomly");
                            // Create a new subject and add exist teacher , exist students and your data
                            Subject subjectToAdd = new Subject(nameNewSubject, classroomNewSubject,teacherNewSubject, randomStudentGroup);

                            // The new subject is added in the university subjects list
                            University.addSubject(subjectToAdd);

                            System.out.println("The new subject was added succesfull: ");
                            System.out.println(University.subjects.toString());
                            break;
                        }else{
                            System.out.println("The teacher with the id" + idTeacherNewSubject + " doesn't exist");
                        }
                        break;
                    case 5:
                        // Enter the new subject classroom
                        try{
                            System.out.println("Enter the student id");
                            scan = new Scanner(System.in);
                            int studentId = scan.nextInt();

                            if(!Formatter.verifyIdMaxSize(studentId)){
                                System.out.println("The student id should be < 10");
                                break;
                            }

                            // List all the subjects in that a student is (search by id)
                            System.out.println("List to all the subjects in where is the student by id: " + studentId);
                            System.out.println(University.getSubjectListByStudentId(studentId).toString());
                        }catch (Exception NumberFormatException){
                            System.out.println("Enter a number (integer)");
                        }
                        break;
                    default:
                        break;
                }
            }catch (Exception NumberFormatException){
                System.out.println("Enter a valid option");
            }

        }










    }

    public static void generateData(){

        // Group students to generates the list of students in the subjects
        List<Student> group1 = new ArrayList<>();
        List<Student> group2 = new ArrayList<>();
        List<Student> group3 = new ArrayList<>();

        //Data Student
        Student student6 = new Student("ANDREA",1234,21);
        Student student1 = new Student("JUAN",12345,22);
        Student student2 = new Student("MARIA",123456,20);
        Student student3 = new Student("CARLOS",1234567,19);
        Student student4 = new Student("ENRIQUE",12345678,24);
        Student student5 = new Student("SAMUEL",123456789,28);


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
        Teacher teacher1 = new TeacherPartTime("ANA", 9876,2500000, 60 );
        Teacher teacher2 = new TeacherFullTime("CAMILA", 98765,3000000, 4 );
        Teacher teacher3 = new TeacherFullTime("SEBASTIAN", 987654,2300000, 2 );
        Teacher teacher4 = new TeacherPartTime("PABLO", 9876543,1600000, 80 );

        teacher1.calculateSalary();
        teacher2.calculateSalary();
        teacher3.calculateSalary();
        teacher4.calculateSalary();

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
        Subject subject3 = new Subject("logic", 3, teacher3, group3);
        Subject subject4 = new Subject("computing", 4, teacher4, group1);

        // Add the Subjects in the University
        University.addSubject(subject1);
        University.addSubject(subject2);
        University.addSubject(subject3);
        University.addSubject(subject4);

        //Print the list of subjects in the University
        System.out.println(University.subjects.toString());
    }


    public static List<Student> createRandomListWithStudents(List<Student> students, int iterations) {
        List<Student> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < iterations; i++) {
            // List empty verification
            if (students.isEmpty()) {
                throw new IllegalArgumentException("The list of studens can be empty");
            }

            // Select a random index in the list of students
            int randomIndex = random.nextInt(students.size());
            Student randomStudent = students.get(randomIndex);

            //The student is added to the random list
            randomList.add(randomStudent);
        }

        return randomList;
    }

}