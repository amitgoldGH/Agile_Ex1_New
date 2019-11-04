package sample;

import java.util.Vector;

public class Lecturer {
    private String name;
    private int id;
    private int experience;
    private int salary;
    private Vector<Course> assigned_Courses;


    public Lecturer(String name, int id, int experience, int salary) {
        this.name = name;
        this.id = id;
        this.experience = experience;
        this.salary = salary;
        this.assigned_Courses = new Vector<Course>();
    }
    public void assign_Course(Course course) {
        this.assigned_Courses.add(course);
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: " + name + ", id: " + id + ", YoE: " + experience + ", Salary: " + salary + "\n" +
                "Courses:\n");
        for (Course c : assigned_Courses) {
            sb.append(c.toString() + "\n");
        }
        return sb.toString();
    }

    public String course_toString() {
        StringBuffer sb = new StringBuffer();
        for (Course c : assigned_Courses) {
            sb.append(c.toString() + "\n");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Vector<Course> getAssigned_Courses() {
        return assigned_Courses;
    }
    public void setAssigned_Courses(Vector<Course> assigned_Courses) {
        this.assigned_Courses = assigned_Courses;
    }
}
