package com.appsco.bunch;
import com.appsco.bunch.User;
import com.appsco.bunch.collegeCourse;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by NicholasArnold on 12/9/16.
 */

public class studyGroup {
    public FirebaseUser Creator;
//    public Calendar startTime;
//    public Calendar endTime;
    public String startTime;
    public collegeCourse classStudying;

    public String message;
    public float intensity;
//    public int maxMembers;
    public String maxMembers;
    public String startDate;

    public List groupMembers = new ArrayList();

    public studyGroup() {
        // Default constructor does nothing
    }

//    public studyGroup(User creator, Calendar startTime, Calendar endTime, collegeCourse classStudying) {
//        // Basic required constructor includes the creator, start and end time, and the class being studied -- sets max members to 6
//        // Whatever isnt set is given a deafult value
//        Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.classStudying = classStudying;
//        maxMembers = 6;
//        intensity = 3;
//        message = "Join my study group for " + classStudying.getCollege() + " " + classStudying.getDept() + classStudying.getCourseNum() + "!";
//    }

//    public studyGroup(User creator, Calendar startTime, Calendar endTime, collegeCourse classStudying, String message) {
//        // Basic constructor with message
//        Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.classStudying = classStudying;
//        this.message = message;
//        maxMembers = 6;
//        intensity = 3;
//    }

//    public studyGroup(User creator, Calendar startTime, Calendar endTime , float intensity, collegeCourse classStudying) {
//        // Basic constructor with intensity
//        Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.intensity = intensity;
//        this.classStudying = classStudying;
//        maxMembers = 6;
//        message = "Join my study group for " + classStudying.getCollege() + " " + classStudying.getDept() + classStudying.getCourseNum() + "!";
//    }

//    public studyGroup(User creator, Calendar startTime, Calendar endTime, collegeCourse classStudying, int maxMembers) {
//        // Basic constructor with max members
//        Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.classStudying = classStudying;
//        this.maxMembers = maxMembers;
//        message = "Join my study group for " + classStudying.getCollege() + " " + classStudying.getDept() + classStudying.getCourseNum() + "!";
//        intensity = 3;
//    }

//    public studyGroup(User creator, Calendar startTime, Calendar endTime, collegeCourse classStudying, String message, float intensity){
//        // Default with message and intensity
//        Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.classStudying = classStudying;
//        this.maxMembers = 6;
//        this.message = message;
//        this.intensity = intensity;
//    }
//
//    public studyGroup(User creator, Calendar startTime, Calendar endTime, collegeCourse classStudying, int maxMembers, String message){
//        Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.classStudying = classStudying;
//        this.maxMembers = 6;
//        this.message = message;
//        this.intensity = 3;
//    }

    public studyGroup(User creator, Calendar startTime, Calendar endTime, collegeCourse classStudying, int maxMembers, float intensity){

    }

//    public studyGroup(User creator, float intensity, String classStudying, String maxMembers) {
//        // Constructor with ALL details filled out
//        this.Creator = creator;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.message = "Join my study group for " + classStudying + " " + classStudying.getDept() + classStudying.getCourseNum() + "!";
//        this.intensity = intensity;
//        this.classStudying = classStudying;
//        this.maxMembers = maxMembers;
//    }

    //temporary Study Group object constructor

    public studyGroup(FirebaseUser creator, float intensity, String classStudying, String maxMembers, String date, String time) {
        // Constructor with ALL details filled out
        this.Creator = creator;
        this.startDate = date;
        this.startTime = time;
        this.message = "Join my study group for " + classStudying + "!";
        this.intensity = intensity;
        this.maxMembers = maxMembers;
    }


    public boolean addMember(FirebaseUser newMember){
        // Returns true if member added, returns false if group full
        if (groupMembers.size() < Integer.valueOf(maxMembers)){
            groupMembers.add(newMember);
            return true;
        } else {
            // Some kind of error should be here
            // Cant add more members than user chosen max
            return false;
        }
    }

    public boolean removeMember(FirebaseUser leavingMember){
        if(groupMembers.contains(leavingMember)){
            groupMembers.remove(leavingMember);
            return true;
        }
        else {
            return false;
        }
    }

    public void updateMessage(String newMessage){
        this.message = newMessage;
    }

}
