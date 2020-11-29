package com.group10.SchooManagementSystem.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData extends UserData{

    private final StringProperty section;
    private final StringProperty grade;
//    private final Attendance studentAttendance;


    public StudentData(String userId, String name,
                       String mail, String phone,
                        String section,
                       String grade) {
        super(userId, name, mail, phone, "Student");
        this.section = new SimpleStringProperty(section);
        this.grade = new SimpleStringProperty(grade);
//        this.studentAttendance = studentAttendance;
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

    public String getGrade() {
        return grade.get();
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

//    public Attendance getStudentAttendance() {
//        return studentAttendance;
//    }

}
