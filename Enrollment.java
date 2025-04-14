package SCRS;

public class Enrollment {
    int enrollmentId;
    int studentId;
    int courseId;

    public Enrollment(int enrollmentId, int studentId, int courseId) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public static void registerCourse(java.util.ArrayList<Enrollment> enrollments, int enrollmentId, int studentId, int courseId) {
        for(Enrollment e : enrollments) {
            if(e.studentId == studentId && e.courseId == courseId) {
                System.out.println("Student already registered for this course.");
                return;
            }
        }
        enrollments.add(new Enrollment(enrollmentId, studentId, courseId));
        System.out.println("Student " + studentId + " registered for Course " + courseId);
    }

    public static void dropCourse(java.util.ArrayList<Enrollment> enrollments, int studentId, int courseId) {
        Enrollment found = null;
        for(Enrollment e : enrollments) {
            if(e.studentId == studentId && e.courseId == courseId) {
                found = e;
                break;
            }
        }
        if(found != null) {
            enrollments.remove(found);
            System.out.println("Dropped course " + courseId + " for student " + studentId);
        } else {
            System.out.println("Enrollment not found!");
        }
    }

    public static void viewEnrolledCourses(java.util.ArrayList<Enrollment> enrollments, int studentId) {
        boolean found = false;
        for(Enrollment e : enrollments) {
            if(e.studentId == studentId) {
                System.out.println("Enrolled Course ID: " + e.courseId);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No courses enrolled for student " + studentId);
        }
    }
}


