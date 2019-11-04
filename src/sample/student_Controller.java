package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class student_Controller {

    static private Student main_Student = null;

    @FXML
    private TextArea registeredCoursesArea;
    @FXML
    private Label nameLbl;
    @FXML
    private Label idLbl;
    @FXML
    private Label welcomeLbl;
    @FXML
    private Label yrLbl;

    @FXML
    void initialize() {
        if (main_Student != null) {
            welcomeLbl.setText("Welcome " + main_Student.getName().split(" ")[0] + ".");
            nameLbl.setText(main_Student.getName().toUpperCase());
            idLbl.setText(main_Student.getId() + "");
            yrLbl.setText(main_Student.getSchool_Year() + "");
            registeredCoursesArea.setText(main_Student.course_toString());
        }
    }

    static public void passStudent(Student s) {
        if (main_Student == null) {
            main_Student = s;
            /*
            main_Student = new Student(s.getName(), s.getId(), s.getSchool_Year(), s.getMonthly_Payment());
            main_Student.setAssigned_Courses(s.getAssigned_Courses());
             */

        }
    }


}
