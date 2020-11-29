package com.group10.SchooManagementSystem.StudentModule;

import com.group10.SchooManagementSystem.Data.Attendance;
import com.group10.SchooManagementSystem.Data.StudentData;
import com.group10.SchooManagementSystem.Data.UserData;
import com.group10.SchooManagementSystem.TeacherModule.AttendanceModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentAttendanceController implements Initializable {


    @FXML
    private TableView<Attendance> attendanceTable;

    @FXML
    private TableColumn<Attendance, String> DateCol,  statusCol;

    private StudentData studentData;
    private ObservableList<Attendance> attendances;
    private StudentAttendanceModel attendanceModel;
    public StudentAttendanceController(StudentData studentData){
        this.studentData = studentData;
        this.attendanceModel= new StudentAttendanceModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.loadAttendance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void loadAttendance() throws SQLException {

        this.attendances = FXCollections.observableArrayList();
        this.attendances = this.attendanceModel.loadAttendance(studentData);
        this.setAttendanceTable(this.attendances);
    }

    public void setAttendanceTable(ObservableList<Attendance> attendances){
        this.DateCol.setCellValueFactory(new PropertyValueFactory<Attendance, String>("date"));
        this.statusCol.setCellValueFactory(new PropertyValueFactory<Attendance, String>("status"));
        this.attendanceTable.setItems(null);
        this.attendanceTable.setItems(attendances);
    }
}
