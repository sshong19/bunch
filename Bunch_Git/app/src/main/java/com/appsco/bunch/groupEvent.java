package com.appsco.bunch;

/**
 * Created by sshong on 12/10/16.
 */

public class groupEvent {

    private String username;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    private String course;

    public String getDate() {
        return date;
    }

    private String date;
    private String location;
    private String time;
    private String maximumppl;
    private float intensity;

    public String getMaximumppl() {
        return maximumppl;
    }

    public void setMaximumppl(String maximumppl) {
        this.maximumppl = maximumppl;
    }


    public groupEvent(){

    }

    public groupEvent(String username, String course, String date, float intensity, String maximumppl, String location, String time) {
        this.course = course;
        this.date = date;
        this.course = course;
        this.time= time;
        this.intensity = intensity;
        this.maximumppl = maximumppl;
        this.location = location;
    }


    public String getTime() {return time; }
    public void setTime(String time) {this.time = time;}

    public String getFirstName() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.username = firstName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

//    public String getStudyClass() {
//        return course;
//    }
//
//    public void setStudyClass(String studyClass) {
//        this.course = studyClass;
//    }

    public String getStartDate() {
        return date;
    }

    public void setStartDate(String startDate) {
        this.date = startDate;
    }


    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }

    public String getMaxMembers() {
        return maximumppl;
    }

    public void setMaxMembers(String maxMembers) {
        this.maximumppl = maxMembers;
    }





}
