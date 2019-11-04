package sample;

import java.util.Vector;

public class Lecturer {
    private String name;
    private int id;
    private int experience;
    private int salary;
    private Vector<Integer> assigned_Courses;


    public Lecturer(String name, int id, int experience, int salary) {
        this.name = name;
        this.id = id;
        this.experience = experience;
        this.salary = salary;
        this.assigned_Courses = new Vector<Integer>();
    }
    public void assign_Course(Course course) {
        this.assigned_Courses.add(course.getCourse_Id());
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: " + name + ", id: " + id + ", YoE: " + experience + ", Salary: " + salary + "\n" +
                "Courses:\n");
        for (int i : assigned_Courses) {
            sb.append(login_Controller.college.getAll_Courses().get(i).toString() + "\n");
        }
        return sb.toString();
    }

    public String course_toString() {
        StringBuffer sb = new StringBuffer();
        for (int i : assigned_Courses) {
            sb.append(login_Controller.college.getAll_Courses().get(i).toString() + "\n");
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
    public Vector<Integer> getAssigned_Courses() {
        return assigned_Courses;
    }
    public void setAssigned_Courses(Vector<Integer> assigned_Courses) {
        this.assigned_Courses = assigned_Courses;
    }
}
