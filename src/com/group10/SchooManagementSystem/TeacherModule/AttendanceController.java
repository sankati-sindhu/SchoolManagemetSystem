package com.group10.SchooManagementSystem.TeacherModule;

import com.group10.SchooManagementSystem.Data.Attendance;
import com.group10.SchooManagementSystem.Data.TeachersData;
import com.group10.SchooManagementSystem.Data.UserData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {

    @FXML
    private Button enterBt;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<Attendance> userTable;

    @FXML
    private TableColumn<Attendance, String> userIdCol,  nameCol;

//    @FXML
//    private TableColumn<String, String> sectionCol, classCol;

    @FXML
    private TableColumn<Attendance, CheckBox> statusCol;



    private AttendanceModel attendanceModel;
    private ObservableList<Attendance> attendances;

    TeachersData teachersData;
    public AttendanceController(TeachersData teachersData){
        this.teachersData = teachersData;
        attendanceModel = new AttendanceModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void clickedEnter(ActionEvent event) {
        LocalDate localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        this.attendances = attendanceModel.loadStudentData(localDate.toString(), teachersData.getSection(), teachersData.getGrade(), teachersData.getUserId());
        this.setUserTable(attendances);
    }

    public void clickedSearch(ActionEvent event) {

    }

    public void setUserTable(ObservableList<Attendance> attendances){
        this.userIdCol.setCellValueFactory(new PropertyValueFactory<Attendance, String>("userId"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<Attendance, String>("name"));
        this.statusCol.setCellValueFactory(new PropertyValueFactory<Attendance, CheckBox>("present"));
//        this.sectionCol.setCellValueFactory(new PropertyValueFactory<String, String>("d"));
//        this.classCol.setCellValueFactory(new PropertyValueFactory<String, String>("6"));
        this.userTable.setItems(null);
        this.userTable.setItems(attendances);
    }

    public void clickedSave(ActionEvent event) throws SQLException {
        for(Attendance attendance: attendances){
            attendance.setStatus(String.valueOf(attendance.getPresent().isSelected()));
            this.attendanceModel.addAttendance(attendance);
        }
    }
}
