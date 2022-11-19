package com.abhi.myfirstproject.CourseServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.abhi.myfirstproject.models.Course;
@Service
public class CourseService {
    private List<Course>getAllCourse = new ArrayList<>();
    public CourseService(){
      getAllCourse.add(new Course(101, "phy", "abhi"));
      getAllCourse.add(new Course(102, "chem", "princu"));
      getAllCourse.add(new Course(103, "math", "abhishek"));
    }

    public List<Course> getAllCourse(){
        System.out.print(getAllCourse.get(0));
       return getAllCourse;
    }

    public Optional<Course> singleCourse( Integer courseID) throws Exception{
        Optional<Course> singleCourse = getAllCourse.stream()
        .filter(course -> courseID.equals(course.getCourseId())).
        findAny();
        if(!singleCourse.isPresent()){
            throw new Exception("course is not found");
        }
        return singleCourse;
    }  

    public List< Course> updateCourse( Integer courseID,  Course updatCourseData){
        Course singleCourse = getAllCourse.stream()
        .filter(course -> courseID.equals(course.getCourseId())).
        findAny().orElse(new Course(404, "not found", "not found"));

        getAllCourse.set(getAllCourse.indexOf(singleCourse), updatCourseData);
        return getAllCourse;
    }

    public List<Course> deleteCourse( Integer courseID){
        getAllCourse.removeIf(course -> courseID.equals(course.getCourseId()));
        return getAllCourse;
    }

    public List<Course> postCourse( Course course) throws Exception{
        Optional<Course> singleCourse = getAllCourse.stream()
        .filter(c -> course.getCourseId().equals(c.getCourseId())).
        findAny();
        if(singleCourse.isPresent()){
            throw new Exception("course with this id is already exists");
        }
        getAllCourse.add(course);
        return getAllCourse;
    }

    

    
    
}
