package com.abhi.myfirstproject.models;

public class Course {
    private Integer courseId;
    private String courseName;
    private String courseInstructor;
    public Course(Integer courseId, String courseName, String courseInstructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseInstructor = courseInstructor;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseInstructor() {
        return courseInstructor;
    }
    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseInstructor=" + courseInstructor
                + "]";
    }
    
}
