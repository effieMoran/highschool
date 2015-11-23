package com.effie.model;

/**
 * Created by effie on 11/21/15.
 */
public class Student {
    private String firstname;
    private String lastname;
    private String career;
    private int fileNumber;
    private int subjectsApproved;
    private static int lastFileNumber = 0;

    public Student(String firstname, String lastname, String career){
        this.firstname = firstname;
        this.lastname = lastname;
        this.career = career;
        lastFileNumber++;
        this.fileNumber = lastFileNumber;
        subjectsApproved = 0;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCareer() {
        return career;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public int getSubjectsApproved() {
        return subjectsApproved;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setFileNumber(int fileNumber) {this.fileNumber = fileNumber;}

    public void setSubjectsApproved(int subjectsApproved) {
        this.subjectsApproved = subjectsApproved;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass() != this.getClass()){ return false; }
        Student student = (Student) o;
        if( student.getFileNumber() != this.getFileNumber()){return false;}
        return true;
    }

    @Override
    public int hashCode() {
        return fileNumber;
    }
}
