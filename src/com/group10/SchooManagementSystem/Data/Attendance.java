package com.group10.SchooManagementSystem.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;


public class Attendance {

    private final StringProperty date;
    private final StringProperty userId;
    private  final StringProperty name;
    private final StringProperty status;
    private final StringProperty giverId;
    private CheckBox present;


    public Attendance(String date, String userId, String giverId, String name) {
        this.date = new SimpleStringProperty(date);
        this.userId = new SimpleStringProperty(userId);
        this.status = new SimpleStringProperty("false");
        this.giverId = new SimpleStringProperty(giverId);
        this.name = new SimpleStringProperty(name);
        present = new CheckBox();
    }
    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getUserId() {
        return userId.get();
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId.set(userId);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {

        this.status.set(status);
        if(status == "true"){
            this.present.setSelected(true);
        }else {
            this.present.setSelected(false);
        }


    }

    public String getGiverId() {
        return giverId.get();
    }

    public StringProperty giverIdProperty() {
        return giverId;
    }

    public void setGiverId(String giverId) {
        this.giverId.set(giverId);
    }

    public CheckBox getPresent() {
        return present;
    }

    public void setPresent(CheckBox present) {
        this.present = present;
    }


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

}
