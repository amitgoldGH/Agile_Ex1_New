package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class lecturer_Controller {

    static private Lecturer main_Lecturer = null;

    public static void passLecturer(Lecturer l) {
        if (main_Lecturer == null)
            main_Lecturer = l;
    }

    @FXML
    private Label welcomeLbl;
    @FXML
    private Label nameLbl;
    @FXML
    private Label idLbl;
    @FXML
    private TextArea courseArea;


    @FXML
    void initialize() {
        if (main_Lecturer != null) {
            welcomeLbl.setText("Welcome " + main_Lecturer.getName());
            nameLbl.setText(main_Lecturer.getName());
            idLbl.setText(main_Lecturer.getId() + "");
            courseArea.setText(main_Lecturer.course_toString());
        }
    }
}
