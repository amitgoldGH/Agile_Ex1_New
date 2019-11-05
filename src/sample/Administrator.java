package sample;

import java.util.Map;

public class Administrator {
    private String name;
    private int id;

    public Administrator(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void register_Student_To_Course(Student s, Course c) { s.register_To_Course(c); }
    public void assign_Lecturer_To_Course(Lecturer l, Course c) {
        c.assign_Lecturer(l);
    }

    public void register_Student_To_College(Student s) { login_Controller.college.add_Student(s); }
    public void register_Lecturer_To_College(Lecturer l) {
        login_Controller.college.add_Lecturer(l);
    }
    public void register_Course_To_College(Course c) { login_Controller.college.add_Course(c); }

    public int monthly_Rev() {
        int monthly_Rev = 0;

        for(Map.Entry<Integer, Student> entry : login_Controller.college.getAll_Students().entrySet())
            monthly_Rev += entry.getValue().getMonthly_Payment();
        for(Map.Entry<Integer, Lecturer> entry : login_Controller.college.getAll_Lecturers().entrySet()) {
            monthly_Rev -= entry.getValue().getSalary();
        }
        /*
        for (Student s : login_Controller.college.getAll_Students())
            monthly_Rev += s.getMonthly_Payment();

        for (Lecturer l : login_Controller.college.getAll_Lecturers())
            monthly_Rev -= l.getSalary();
        */

        return monthly_Rev;
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


}
