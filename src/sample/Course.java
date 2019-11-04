package sample;

import java.util.Vector;

public class Course {
    private String course_Name;
    private int course_Id;
    private String day;
    private String hours;
    private String semester;
    private Lecturer assigned_Lecturer;

    public Course(String course_Name, int course_Id, String day, String hours, String semester, Lecturer lecturer) {
        this(course_Name, course_Id, day, hours, semester);
        this.assigned_Lecturer = lecturer;
        if (lecturer != null)
            lecturer.assign_Course(this);
    }

    public Course(String course_Name, int course_Id, String day, String hours, String semester) {
        this.course_Name = course_Name;
        this.course_Id = course_Id;
        this.day = day;
        this.hours = hours;
        this.semester = semester;
        this.assigned_Lecturer = null;
    }
    public void assign_Lecturer(Lecturer l) {
        if (l != this.assigned_Lecturer) { //Check if already assigned to this course
            if (this.assigned_Lecturer != null) { // Check if another lecturer already assigned to this course
                this.assigned_Lecturer.getAssigned_Courses().remove(this);
            }
            this.assigned_Lecturer = l;
            l.assign_Course(this);
        }
    }
    @Override
    public String toString() {
        return course_Name + "(" + course_Id + ")"
                + ", Lecturer: " + ((assigned_Lecturer != null) ? assigned_Lecturer.getName() : "None") + ", " + day + "(" + hours + ")" + ", " + semester;
    }

    public int getCourse_Id() {
        return course_Id;
    }
}
