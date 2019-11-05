package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 360, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        login_Controller.setCollege(new College("Afeka"));
        Administrator admin = new Administrator("Amit", 0);
        login_Controller.college.setAdmin(admin);
        Lecturer l = new Lecturer("Johnny", 123, 5, 5500);
        Student san = new Student("San", 10, 2015, 1776);
        Student sun = new Student("Sun" , 11, 2016, 1896);
        Course c1 = new Course("Math", 10000, "Sunday", "8:00-9:50", "Summer");
        Course c2 = new Course("Physics", 10001, "Sunday", "11:00-12:50", "Summer");
        admin.register_Course_To_College(c1);
        admin.register_Course_To_College(c2);
        admin.register_Student_To_College(san);
        admin.register_Student_To_College(sun);
        admin.register_Lecturer_To_College(l);

        admin.assign_Lecturer_To_Course(l, c1);
        admin.assign_Lecturer_To_Course(l, c2);
        admin.register_Student_To_Course(san, c1);
        admin.register_Student_To_Course(san, c2);
        admin.register_Student_To_Course(sun, c2);

        //System.out.println(l.toString());

        //login_Controller.passCollege(Afeka);
        launch(args);
        System.exit(0);
    }
}
