package com.appsco.bunch;

/**
 * Created by sshong on 12/10/16.
 */

public class groupEvent {

    private String firstName,lastName,studyClass,startDate,message,intensity,maxMembers;

    public groupEvent(){

    }

    public groupEvent(String firstName, String lastName, String studyClass, String startDate, String message, String intensity, String maxMembers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studyClass = studyClass;
        this.startDate = startDate;
        this.message = message;
        this.intensity = intensity;
        this.maxMembers = maxMembers;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(String studyClass) {
        this.studyClass = studyClass;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(String maxMembers) {
        this.maxMembers = maxMembers;
    }





}
