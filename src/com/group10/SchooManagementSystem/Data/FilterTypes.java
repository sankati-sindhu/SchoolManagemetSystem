package com.group10.SchooManagementSystem.Data;

public enum FilterTypes {
    userId, firstName, lastName ;

    private FilterTypes(){ }
    public String value(){
        return name();
    }
    public static FilterTypes fromValue(String v){
        return valueOf(v);
    }
}
