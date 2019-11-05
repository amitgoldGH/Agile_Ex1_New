package sample;

import java.util.Vector;

public class Student {
    private String name;
    private int id;
    private int school_Year;
    private int monthly_Payment;
    private Vector<Integer> assigned_Courses;

    public Student(String name, int id, int school_Year, int monthly_Payment) {
        this.name = name;
        this.id = id;
        this.school_Year = school_Year;
        this.monthly_Payment = monthly_Payment;
        this.assigned_Courses = new Vector<Integer>();
    }

    public boolean register_To_Course(Course c) {
        if (!(assigned_Courses.contains(c))) {
            assigned_Courses.add(c.getCourse_Id());
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: " + name + "(" + id + "), School Year: " + school_Year + ", Monthly Pay: "
                + monthly_Payment + this.course_toString());
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
    public int getSchool_Year() {
        return school_Year;
    }
    public void setSchool_Year(int school_Year) {
        this.school_Year = school_Year;
    }
    public int getMonthly_Payment() {
        return monthly_Payment;
    }
    public void setMonthly_Payment(int monthly_Payment) {
        this.monthly_Payment = monthly_Payment;
    }
    public Vector<Integer> getAssigned_Courses() {
        return assigned_Courses;
    }
    public void setAssigned_Courses(Vector<Integer> assigned_Courses) {
        this.assigned_Courses = assigned_Courses;
    }
}
