package gradeAdministration;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Class that provides an interface to interact with the grade administration
 */
public class Main {
    /* List of all registered courses */
    ArrayList<Course> courseList;
    /* List of all registered students */
    ArrayList<Student> studentList;

    Scanner sc;

    public static void main(String[] args) {
        Main main = new Main();
        main.courseList = new ArrayList<>();
        main.studentList = new ArrayList<>();
        main.run();
    }

    /**
     * Starting point of the program, it will print different menus based on the user input
     */
    public void run() {
        boolean done = false;

        while (!done) {
            printOverviewMenu();

            sc = new Scanner(System.in);
            int input = sc.nextInt();
            while (input <= 0 || input > 4) {
                System.out.println("Invalid input, please choose a number between 1 and 4");
                input = sc.nextInt();
            }
            switch (input) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    courseMenu();
                    break;
                case 3:
                    gradeMenu();
                    break;
                case 4:
                    done = true;
                    break;
            }
        }
        sc.close();
    }

    /**
     * Shows the grade menu that allows the user to print, add or modify grades.
     */
    private void gradeMenu() {
        boolean done = false;
        while (!done) {
            System.out.println(
                    "========= GRADE MENU ========\n" +
                            "1 - Print all grades\n" +
                            "2 - Add grade\n" +
                            "3 - Modify grade\n" +
                            "4 - Exit to overview menu\n" +
                            "===============================\n" +
                            "What do you want to do? (Enter a number between 1-4)");
            int input = sc.nextInt();
            while (input < 1 || input > 4) {
                input = sc.nextInt();
            }

            switch (input) {
                case 1:
                    printAllGrades();
                    break;
                case 2:
                    addStudentGrade();
                    break;
                case 3:
                    modifyGrade();
                    break;
                case 4:
                    done = true;
                    break;
            }
        }
    }

    public void startGradeUpdate() {
        // Dummy-method
        // You may use this method to check when the process for updating / adding a 
        // grade is started after the user has provided the required inputs.  
    }

    /**
     * Allows the user to register a grade for a course for a specific student
     */
    public void addStudentGrade() {
        System.out.println("For which student should a grade be added? Give the corresponding student number");
        Student s = this.studentList.get(sc.nextInt());
        Course course = null;
        while (course == null) {
            System.out.println("For which course should a grade be added? Give the corresponding course code");
            String courseCode = sc.next();
            for (Course c : this.courseList) {
                if (c.courseCode.equals(courseCode)) {
                    course = c;
                    break;
                }
            }
        }
        int grade = 0;
        while (grade < 1 || grade > 10) {
            System.out.println("Which grade should be registered for this student/course combination?");
            grade = sc.nextInt();
        }
        startGradeUpdate();
        course.addGrade(s, grade);
        simulateNetworkDelay();
        updateStudentCredits(s);
    }

    /**
     * Allows the user to modify the grade of a student for a specific course
     */
    public void modifyGrade() {
        System.out.println("For which student should a grade be modified? Give the corresponding student number");
        Student s = this.studentList.get(sc.nextInt());
        Course course = null;
        while (course == null) {
            System.out.println("For which course should a grade be modified? Give the corresponding course code");
            String courseCode = sc.next();
            for (Course c : this.courseList) {
                if (c.courseCode.equals(courseCode)) {
                    course = c;
                    break;
                }
            }
        }
        int grade = 0;
        while (grade < 1 || grade > 10) {
            System.out.println("Which new grade should be registered for this student/course combination?");
            grade = sc.nextInt();
        }
        startGradeUpdate();
        course.addGrade(s, grade);
        simulateNetworkDelay();
        updateStudentCredits(s);
    }

    

    /**
     * Sets the amount of credits a student has earned based on which courses (s)he passed
     * @param s student
     */
    private void updateStudentCredits(Student s) {
        int credits = 0;
        for (Course c : this.courseList) {
            if (c.studentPassedCourse(s)) {
                credits += c.getCredit();
            }
        }
        s.setCredits(credits);
        simulateNetworkDelay();
    }

    /**
     * Prints all grades
     */
    public void printAllGrades() {
        for (Course c : this.courseList) {
            System.out.println("Course: "+c.getName());
            System.out.println("Grades: "+c.getGrades().toString());
        }
    }

    /**
     * Shows the course menu, allows the user to print, add or delete courses
     */
    private void courseMenu() {
        boolean done = false;
        while (!done) {
            System.out.println(
                    "========= COURSE MENU ========\n" +
                            "1 - Print all courses\n" +
                            "2 - Add course\n" +
                            "3 - Delete course\n" +
                            "4 - Enroll student in a course\n"+
                            "5 - Exit to overview menu\n" +
                            "===============================\n" +
                            "What do you want to do? (Enter a number between 1-5)");
            int input = sc.nextInt();
            while (input < 1 || input > 5) {
                input = sc.nextInt();
            }

            switch (input) {
                case 1:
                    printAllCourses();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    enrollStudentInCourse();
                    break;
                case 5:
                    done = true;
                    break;
            }
        }
    }

    private void enrollStudentInCourse() {
        System.out.println("Which student should be enrolled in a course? Give the corresponding student number");
        Student s = this.studentList.get(sc.nextInt());
        Course course = null;
        while (course == null) {
            System.out.println("For which course should the student be enrolled? Give the corresponding course code");
            String courseCode = sc.next();
            for (Course c : this.courseList) {
                if (c.courseCode.equals(courseCode)) {
                    course = c;
                    break;
                }
            }
        }
        course.enrollStudent(s);
        simulateNetworkDelay();
    }

    /**
     * Allows the user to register a new course
     */
    public void addCourse() {
        System.out.println("Course code: ");
        String courseCode = sc.next();
        sc.nextLine();
        System.out.println("Course name: ");
        String courseName = sc.nextLine();
        System.out.println("Starting block: ");
        String startingBlock = sc.next();
        sc.nextLine();
        System.out.println("Lecturer:");
        String lecturer = sc.nextLine();
        System.out.println("Academic year: ");
        int year = sc.nextInt();
        System.out.println("Amount of credits: ");
        double credits = sc.nextDouble();
        Course c = new Course(courseCode, courseName, credits, year, startingBlock, lecturer);
        this.courseList.add(c);
        simulateNetworkDelay();
    }

    /**
     * Allows the user to delete a registered course
     */
    public void deleteCourse() {
        System.out.println("Which course should be deleted? Give the corresponding course code: ");
        String courseToDelete = sc.next();
        this.courseList.removeIf(course -> course.courseCode.equals(courseToDelete));
        simulateNetworkDelay();
    }

    /**
     * Prints all registered courses
     */
    public void printAllCourses() {
        System.out.println(courseList.toString());
    }

    /**
     * Shows the student menu, allows the user to print, add, modify and delete student info
     */
    private void studentMenu() {
        boolean done = false;
        while (!done) {
            System.out.println(
                    "========= STUDENT MENU ========\n" +
                            "1 - Print all students\n" +
                            "2 - Add student info\n" +
                            "3 - Modify student info\n" +
                            "4 - Delete student info\n" +
                            "5 - Exit to overview menu\n" +
                            "===============================\n" +
                            "What do you want to do? (Enter a number between 1-5)");
            int input = sc.nextInt();
            while (input < 1 || input > 5) {
                input = sc.nextInt();
            }

            switch (input) {
                case 1:
                    printAllStudents();
                    break;
                case 2:
                    addStudentInfo();
                    break;
                case 3:
                    modifyStudentInfo();
                    break;
                case 4:
                    deleteStudentInfo();
                    break;
                case 5:
                    done = true;
                    break;
            }
        }
    }

    /**
     * Allows user to add a new student to the system
     */
    public void addStudentInfo() {
        System.out.println("What is the student's name?");
        Student s = new Student(sc.next(), studentList.size());
        this.studentList.add(s);
        simulateNetworkDelay();
    }

    /**
     * Allows user to modify a student's info based on his/her student number
     */
    public void modifyStudentInfo() {
        System.out.println("Which student's information do you wish to modify? Give the student number of that student: ");
        int studentNr = sc.nextInt();
        Student s = this.studentList.get(studentNr);
        System.out.println("What is the student's new name?");
        String name = sc.next();
        s.setName(name);
        simulateNetworkDelay();
    }

    /**
     * Allows the user to delete a student's info
     */
    public void deleteStudentInfo() {
        System.out.println("Which student's information should be deleted? Give the student number of that student: ");
        int studentNr = sc.nextInt();
        this.studentList.removeIf(student -> student.studentNumber == studentNr);
        simulateNetworkDelay();
    }

    /**
     * Prints all students that are registered in the system
     */
    public void printAllStudents() {
        System.out.println(studentList.toString());
    }

    /**
     * Returns a set that contains the ids of all students. 
     */
    public HashSet<Integer> getStudentIds() {
        return studentList.stream()
            .map(s -> s.studentNumber)
            .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Returns an immutable view of all students in the system.
     */
    public List<Student> getStudentsView() {
        return Collections.unmodifiableList(this.studentList);
    }

    /**
     * Prints the menu
     */
    private void printOverviewMenu() {
        System.out.println("Welcome to Grade Administration!\n" +
                            "============ MENU =============\n" +
                            "1 - Student menu (add/modify/delete students)\n" +
                            "2 - Course menu (add/modify/delete courses)\n" +
                            "3 - Grade menu (add/modify/delete grades)\n" +
                            "4 - Exit\n" +
                            "===============================\n" +
                            "What do you want to do? (Enter a number between 1-4)");
    }

    public void simulateNetworkDelay() {
        int time = ThreadLocalRandom.current().nextInt(0, 4);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("System was interrupted in sleep.");
        }
    }
}
