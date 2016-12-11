//package com.appsco.bunch;
//
//import java.util.Map;
//import java.util.HashMap;
//import java.util.Scanner;
//
///**
// * Created by NicholasArnold on 12/9/16.
// * This class is a model for college courses: it's members include the course's college, department and number
// */
//
//public class collegeCourse {
//    private Map courseInfo = new HashMap();
//
//    public collegeCourse() {
//        this.courseInfo.put("College", "None");
//        this.courseInfo.put("Department", "None");
//        this.courseInfo.put("CourseNum", "String");
//    }
//
//    public collegeCourse(String college, String dept, String courseNum){
//        this.courseInfo.put("College", college);
//        this.courseInfo.put("Department", dept);
//        this.courseInfo.put("CourseNum", courseNum);
//    }
//
//    public Map getCourseInfo() {
//        return courseInfo;
//    }
//
//    public String getCollege(){
//        String search = "College";
//        String college;
//        if (courseInfo.containsKey(search)){
//            college = (String) courseInfo.get(search);
//            return college;
//        }
//        else {
//            return "None";
//        }
//    }
//
//    public String getDept(){
//        String search = "Department";
//        String dept;
//        if (courseInfo.containsKey(search)){
//            dept = (String) courseInfo.get(search);
//            return dept;
//        }
//        else {
//            return "None";
//        }
//    }
//
//    public String getCourseNum(){
//        String search = "CourseNum";
//        String num;
//        if (courseInfo.containsKey(search)){
//            num = (String) courseInfo.get(search);
//            return num;
//        }
//        else {
//            return "None";
//        }
//    }
//
//    public void setCollege(String college){
//        courseInfo.put("College", college);
//    }
//
//    public void setDept(String dept){
//        courseInfo.put("Department",dept);
//    }
//
//    public void setCourseNum(String num){
//        courseInfo.put("Department", num);
//    }
//}
