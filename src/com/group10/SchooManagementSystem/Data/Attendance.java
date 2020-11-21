package com.group10.SchooManagementSystem.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Attendance {


    private final StringProperty date;
    private final StringProperty status;

    public Attendance(String date, String status) {
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
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

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }



}
