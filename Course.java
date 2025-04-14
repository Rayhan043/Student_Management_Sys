package SCRS;

public class Course {
    int id;
    String name;
    String department;

    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public static void viewCourses(java.util.ArrayList<Course> courses) {
        if(courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("---- Course List ----");
        for(Course c : courses) {
            System.out.println("ID: " + c.id + ", Name: " + c.name + ", Department: " + c.department);
        }
    }

    public static boolean checkCourse(java.util.ArrayList<Course> courses, int cid) {
        for(Course c : courses) {
            if(c.id == cid) return true;
        }
        return false;
    }
}


