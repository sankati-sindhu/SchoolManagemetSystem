package com.group10.SchooManagementSystem.Data;

public enum UserTypes {
    Admin, Student, Teacher;

    private UserTypes(){ }
    public String value(){
        return name();
    }
    public static UserTypes fromValue(String v){
        return valueOf(v);
    }
}
