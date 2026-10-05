package gradeAdministration;

public class GradeScenario {
    public static void main(String[] args) {
        int grade = args.length > 0 ? Integer.parseInt(args[0]) : 7;

        Course course = new Course("2001", "System Validation", 5, 1, "Q1", "Dr X");
        Student student = new Student("alice", 0);

        course.enrollStudent(student);
        course.addGrade(student, grade);

        System.out.println(course);
    }
}
