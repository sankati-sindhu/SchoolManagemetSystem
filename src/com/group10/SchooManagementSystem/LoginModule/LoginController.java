package com.group10.SchooManagementSystem.LoginModule;

import com.group10.SchooManagementSystem.AdminModule.AdminController;
import com.group10.SchooManagementSystem.StudentModule.StudentController;
import com.group10.SchooManagementSystem.Data.UserTypes;
import com.group10.SchooManagementSystem.TeacherModule.TeacherController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbStatus;
    @FXML
    private TextField userId;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<UserTypes> typeCb;

    @FXML
    private Button loginBt;

    @FXML
    private Label loginError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(!this.loginModel.isConnected()){
            this.dbStatus.setText("Unable to connected to the database");
        }else{
            this.dbStatus.setText("><");
        }
        this.typeCb.setItems(FXCollections.observableArrayList(UserTypes.values()));
    }

    @FXML
    public void clickLogin(ActionEvent event){

        try {
            if(this.loginModel.isLogin(this.userId.getText(), this.password.getText(),
                    this.typeCb.getValue().toString())){
                System.out.println(this.typeCb.getValue().toString());
                Stage stage = (Stage) this.loginBt.getScene().getWindow();
                stage.close();
                switch (( this.typeCb.getValue()).toString()){
                    case "Admin":
                        adminLogin();
                        break;
                    case "Student":
                        studentLogin(this.userId.getText());
                        break;
                    case "Teacher":
                        teacherLogin(this.userId.getText());;
                        break;
                    default:
                        System.out.println("NO such option");

                }
            }
        } catch (Exception e) {
            this.loginError.setText("wrong credentials");
            e.printStackTrace();
        }


    }

    public void studentLogin(String text){
        /*Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();*/
        try {
            Callback<Class<?>, Object> controllerFactory = type -> {
                if (type == StudentController.class) {
                    return new StudentController(text);
                } else {
                    try {
                        return type.newInstance() ; // default behavior - invoke no-arg construtor
                    } catch (Exception exc) {
                        System.err.println("Could not create controller for "+type.getName());
                        throw new RuntimeException(exc);
                    }
                }
            };
            Stage studentStage = new Stage();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/group10/SchooManagementSystem/StudentModule/student.fxml"));
            fxmlLoader.setControllerFactory(controllerFactory);
            AnchorPane studentRoot = fxmlLoader.load();
            StudentController studentController = fxmlLoader.getController();
            Scene scene = new Scene(studentRoot);
            studentStage.setScene(scene);
            studentStage.setTitle("Student Module");
            studentStage.setResizable(false);
            studentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void adminLogin(){

        try {

            Stage adminStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            AnchorPane adminRoot = fxmlLoader.load(getClass()
                    .getResource("/com/group10/SchooManagementSystem/AdminModule/admin.fxml").openStream());
            AdminController adminController = fxmlLoader.getController();

            Scene adminScene = new Scene(adminRoot);
            adminStage.setScene(adminScene);
            adminStage.setTitle("Admin Module");
            adminStage.setResizable(true);
            adminStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teacherLogin(String text){

        try {
            Callback<Class<?>, Object> controllerFactory = type -> {
                if (type == TeacherController.class) {
                    return new TeacherController(text);
                } else {
                    try {
                        return type.newInstance() ; // default behavior - invoke no-arg construtor
                    } catch (Exception exc) {
                        System.err.println("Could not create controller for "+type.getName());
                        throw new RuntimeException(exc);
                    }
                }
            };
            Stage teacherStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/group10/SchooManagementSystem/TeacherModule/teacher.fxml"));
            fxmlLoader.setControllerFactory(controllerFactory);
            AnchorPane teacherRoot = fxmlLoader.load();
            TeacherController teacherController = fxmlLoader.getController();
            Scene teacherScene = new Scene(teacherRoot);
            teacherStage.setScene(teacherScene);
            teacherStage.setTitle("Teacher Module");
            teacherStage.setResizable(true);
            teacherStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
