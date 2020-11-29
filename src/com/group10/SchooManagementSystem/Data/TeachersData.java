package com.group10.SchooManagementSystem.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class TeachersData extends UserData{

    private final StringProperty grade;
    private final StringProperty section;
    private ArrayList<Permissions> permissions;

    public TeachersData(String userId, String name,
                        String mail, String phone,
                        String grade, String section, String department) {
        super(userId, name, mail, phone, "Teacher");
        this.grade = new SimpleStringProperty(grade);
        this.section = new SimpleStringProperty(section);
        this.department = new SimpleStringProperty(department);
    }
    public String getGrade() {
        return grade.get();
    }
    public StringProperty gradeProperty() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade.set(grade);
    }
    public String getSection() {
        return section.get();
    }
    public StringProperty sectionProperty() {
        return section;
    }

    public void setSection(String section) {
        this.section.set(section);
    }

    public String getDepartment() {
        return department.get();
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    private final StringProperty department;

    public ArrayList<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permissions> permissions) {
        this.permissions = permissions;
    }
}
