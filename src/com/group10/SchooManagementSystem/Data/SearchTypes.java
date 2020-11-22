package com.group10.SchooManagementSystem.Data;

public enum SearchTypes {
    Admin, Student, Teacher;

    private SearchTypes(){ }
    public String value(){
        return name();
    }
    public static SearchTypes fromValue(String v){
        return valueOf(v);
    }
}
