package SCRS;

public class Student {
    int id;
    String name;
    int age;
    String gender;

    public Student(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static void viewStudents(java.util.ArrayList<Student> students) {
        if(students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("---- Student List ----");
        for(Student s : students) {
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Age: " + s.age + ", Gender: " + s.gender);
        }
    }

    public static boolean checkStudent(java.util.ArrayList<Student> students, int sid) {
        for(Student s : students) {
            if(s.id == sid) return true;
        }
        return false;
    }
}
