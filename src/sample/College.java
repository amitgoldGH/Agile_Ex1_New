package sample;

import javax.management.loading.MLetContent;
import java.util.HashMap;
import java.util.Vector;

public class College {
    private String college_Name;
    private Administrator admin;
    private HashMap<Integer, Lecturer> all_Lecturers = new HashMap<Integer, Lecturer>();
    private HashMap<Integer, Student> all_Students = new HashMap<Integer, Student>();
    private HashMap<Integer, Course> all_Courses = new HashMap<Integer, Course>();

    public boolean add_Lecturer(Lecturer l) {
        if (l != null && !(all_Lecturers.containsKey(l.getId()))) {
                all_Lecturers.put(l.getId(), l);
                return true;
        }
        else
            return false; // Already in college.
    }
    public boolean add_Student(Student s) {
        if (s != null && !(all_Students.containsKey(s.getId()))) {
            all_Students.put(s.getId(), s);
            return true;
        }
        else
            return false; // Already in college.
    }
    public boolean add_Course(Course c) {
        if (c != null && !(all_Courses.containsKey(c.getCourse_Id()))) {
            all_Courses.put(c.getCourse_Id(), c);
            return true;
        }
        else
            return false; // Already in college.
    }

    public College(String name) {
        this.college_Name = name;
        this.admin = null;
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
    }

    public HashMap<Integer, Lecturer> getAll_Lecturers() { return all_Lecturers; }
    public HashMap<Integer, Student> getAll_Students() { return all_Students; }
    public HashMap<Integer, Course> getAll_Courses() { return all_Courses; }
}
