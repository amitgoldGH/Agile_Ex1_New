package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class login_Controller {
    static private College college;

    static public void passCollege(College c) {
        college = c;
    }

    @FXML
    private Label loginLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private Label statusLbl;
    @FXML
    private Button loginBtn;

    @FXML
    private ComboBox<String> roleBox = new ComboBox<>();
    ObservableList<String> roleList = FXCollections.observableArrayList("Student", "Lecturer", "Administrator");

    @FXML
    void initialize() {
        roleBox.setValue("Student");
        roleBox.setItems(roleList);
    }


    @FXML
    private void handleButtonAction(ActionEvent event) {
        statusLbl.setText("Login was clicked");

        String name = nameField.getText();
        String id = idField.getText();
        String role = roleBox.getValue().toString();

        //System.out.println(this.college.getAll_Courses().toString());


        System.out.println("User : " + name);
        System.out.println("Id : " + id);
        System.out.println("Role: " + role);

        boolean flag = false;
        try {
            Parent root = null;
            switch (role) {
                case "Student" : {
                    System.out.println("Student selected");
                    for (Student s : college.getAll_Students()) {
                        if (s.getName().equalsIgnoreCase(name) && (s.getId() + "").equalsIgnoreCase(id)) {
                            flag = true;
                            student_Controller.passStudent(s);
                            root = FXMLLoader.load(getClass().getResource("studentPage.fxml"));
                            break;
                        }
                    }
                    if (flag == true)
                        System.out.println("Student found!");
                    else
                        System.out.println("Student not found");
                    break;
                }
                case "Lecturer" : {
                    System.out.println("Lecturer selected");
                    for (Lecturer l : college.getAll_Lecturers()) {
                        if (l.getName().equalsIgnoreCase(name) && (l.getId() + "").equalsIgnoreCase(id)) {
                            flag = true;
                            lecturer_Controller.passLecturer(l);
                            root = FXMLLoader.load(getClass().getResource("lecturerPage.fxml"));
                            break;
                        }
                    }
                    if (flag == true)
                        System.out.println("Lecturer found!");
                    else
                        System.out.println("Lecturer not found");
                    break;
                }
                case "Administrator" : {
                    System.out.println("Administrator selected");
                    if (college.getAdmin().getName().equalsIgnoreCase(name) && (college.getAdmin().getId() + "").equalsIgnoreCase(id)) {
                        flag = true;
                        admin_Controller.passAdmin(college.getAdmin());
                        root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
                        break;
                    }

                    if (flag == true)
                        System.out.println("Administrator found!");
                    else
                        System.out.println("Administrator not found");
                    break;
                }
                default : {
                    System.exit(0);
                    break;
                }
            }
            if (flag == true) {
                Stage stage = new Stage();
                stage.setTitle(role);
                stage.setScene(new Scene(root, 600, 400));
                stage.show();

                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
            else {
                statusLbl.setText("Invalid details");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
