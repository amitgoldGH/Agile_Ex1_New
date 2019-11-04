package sample;

import javax.management.loading.MLetContent;
import java.util.Vector;

public class College {
    private String college_Name;
    private Administrator admin;
    private Vector<Lecturer> all_Lecturers;
    private Vector<Student> all_Students;
    private Vector<Course> all_Courses;

    public boolean add_Lecturer(Lecturer l) {
        if (!(all_Lecturers.contains(l))) {
            all_Lecturers.add(l);
            return true;
        }
        else
            return false; // Already in college.
    }
    public boolean add_Student(Student s) {
        if (!(all_Students.contains(s))) {
            all_Students.add(s);
            return true;
        }
        else
            return false;
    }
    public boolean add_Course(Course c) {
        if (!(all_Courses.contains(c))) {
            all_Courses.add(c);
            return true;
        }
        else
            return false;
    }

    public College(String name) {
        this.college_Name = name;
        this.admin = null;
        all_Lecturers = new Vector<Lecturer>();
        all_Students = new Vector<Student>();
        all_Courses = new Vector<Course>();
    }
    public College(String name, Administrator admin) {
        this(name);
        if (admin != null) {
            this.setAdmin(admin);
        }
    }

    public Administrator getAdmin() { return admin; }
    public void setAdmin(Administrator admin) {
        this.admin = admin;
        admin.setCollege(this);
    }

    public Vector<Lecturer> getAll_Lecturers() { return all_Lecturers; }
    public Vector<Student> getAll_Students() { return all_Students; }
    public Vector<Course> getAll_Courses() { return all_Courses; }
}
