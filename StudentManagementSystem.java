package SCRS;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        int choice, sid, cid, enrollmentId = 1;

        while(true) {
            System.out.println("\n=== Student Course Registration System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Register for Course");
            System.out.println("6. Drop Course");
            System.out.println("7. View Enrolled Courses");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();
                    sc.nextLine(); // flush
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // flush
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    students.add(new Student(sid, name, age, gender));
                    System.out.println("Student added!");
                    break;

                case 2:
                    Student.viewStudents(students);
                    break;

                case 3:
                    System.out.print("Enter Course ID: ");
                    cid = sc.nextInt();
                    sc.nextLine(); // flush
                    System.out.print("Enter Course Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    courses.add(new Course(cid, cname, dept));
                    System.out.println("Course added!");
                    break;

                case 4:
                    Course.viewCourses(courses);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();
                    if(Student.checkStudent(students, sid)) {
                        System.out.print("Enter Course ID: ");
                        cid = sc.nextInt();
                        if(Course.checkCourse(courses, cid)) {
                            Enrollment.registerCourse(enrollments, enrollmentId++, sid, cid);
                        } else {
                            System.out.println("Course not found!");
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    cid = sc.nextInt();
                    Enrollment.dropCourse(enrollments, sid, cid);
                    break;

                case 7:
                    System.out.print("Enter Student ID: ");
                    sid = sc.nextInt();
                    Enrollment.viewEnrolledCourses(enrollments, sid);
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
