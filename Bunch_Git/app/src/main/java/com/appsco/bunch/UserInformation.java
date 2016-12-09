package com.appsco.bunch;

import com.appsco.bunch.collegeCourse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sshong on 12/8/16.
 */

public class UserInformation {

    private String firstName;
    private String lastName;
    private String college;
    private String major;
    private String year;
    public Map coursesTaking = new HashMap();


    // USER CONSTRUCTORS
    public UserInformation(){
    }
    public UserInformation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserInformation(String firstName, String lastName, String college, String major, String year){
        this.firstName = firstName;
        this.lastName = lastName;
        this.college = college;
        this.major = major;
        this.year = year;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
