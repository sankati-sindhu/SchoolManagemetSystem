package com.group10.SchooManagementSystem.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData {
    private final StringProperty userId;
    private final StringProperty name;
    private final StringProperty userType;
    private final StringProperty mail;
    private final StringProperty phone;

    public UserData(String userId, String firstName,
                    String mail, String phone,
                    String userType){
        this.userId = new SimpleStringProperty(userId );
        this.name = new SimpleStringProperty(firstName );
        this.mail = new SimpleStringProperty(mail );
        this.phone = new SimpleStringProperty(phone );
        this.userType = new SimpleStringProperty(userType);
    }
    public void setUserId(String userId) {
        this.userId.set(userId);
    }

    public String getUserType() {
        return userType.get();
    }

    public StringProperty userTypeProperty() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType.set(userType);
    }



    public void setMail(String mail) {
        this.mail.set(mail);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }



    public String getUserId() {
        return userId.get();
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    public String getMail() {
        return mail.get();
    }

    public StringProperty mailProperty() {
        return mail;
    }
    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

//    //public void setName(String name) {
//        this.name.set(name);
//    }



}
