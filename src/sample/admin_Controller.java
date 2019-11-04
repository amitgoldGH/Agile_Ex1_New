package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class admin_Controller {
    static private Administrator main_Admin = null;

    @FXML
    private Label revLbl;
    @FXML
    private Label nameLbl;
    @FXML
    private Label idLbl;

    @FXML
    void initialize() {
        if (main_Admin != null) {
            nameLbl.setText(main_Admin.getName());
            idLbl.setText(main_Admin.getId() + "");
            revLbl.setText(main_Admin.monthly_Rev() + "");
        }
    }



    static public void passAdmin(Administrator admin) {
        if (main_Admin == null) {
            main_Admin = admin;
            /*
            main_Admin = new Administrator(admin.getName(), admin.getId());
            main_Admin.setCollege(admin.getCollege());
             */

        }
    }
}
