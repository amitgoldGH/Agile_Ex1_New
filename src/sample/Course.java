package sample;

public class Course {
    private String course_Name;
    private int course_Id;
    private String day;
    private String hours;
    private String semester;
    private int assigned_Lecturer_Id;

    public Course(String course_Name, int course_Id, String day, String hours, String semester, Lecturer lecturer) {
        this(course_Name, course_Id, day, hours, semester);
        this.assigned_Lecturer_Id = lecturer.getId();
        if (lecturer != null)
            lecturer.assign_Course(this);
    }

    public Course(String course_Name, int course_Id, String day, String hours, String semester) {
        this.course_Name = course_Name;
        this.course_Id = course_Id;
        this.day = day;
        this.hours = hours;
        this.semester = semester;
        this.assigned_Lecturer_Id = -1;
    }
    public void assign_Lecturer(Lecturer l) {
        if (l.getId() != this.assigned_Lecturer_Id) { //Check if already assigned to this course
            if (this.assigned_Lecturer_Id > 0) { // Check if another lecturer already assigned to this course
                login_Controller.college.getAll_Lecturers().get(assigned_Lecturer_Id).getAssigned_Courses().remove(this);
            }
            this.assigned_Lecturer_Id = l.getId();
            l.assign_Course(this);
        }
    }
    @Override
    public String toString() {
        return course_Name + "(" + course_Id + ")"
                + ", Lecturer: " + ((assigned_Lecturer_Id > 0) ? login_Controller.college.getAll_Lecturers().get(assigned_Lecturer_Id).getName() : "None") + ", " + day + "(" + hours + ")" + ", " + semester;
    }

    public int getCourse_Id() {
        return course_Id;
    }
}
