package com.abhi.myfirstproject.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abhi.myfirstproject.CourseServices.CourseService;
import com.abhi.myfirstproject.models.Course;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(path="/api")
public class CourseController {
    @Autowired
    CourseService courseService;
    
    @GetMapping("/course")
    
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    // getting indiual courses
    @GetMapping("/course/{cid}")
    public Optional<Course> singleCourse(@PathVariable("cid") Integer courseID) throws Exception{
       try{
        return courseService.singleCourse(courseID);
       }
       catch(Exception exe){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,exe.getMessage());
       }
    }

    // updating your list
    @PutMapping("/course/{cid}")
    public List< Course> updateCourse(@PathVariable("cid") Integer courseID, @RequestBody Course updatCourseData){
        
        return courseService.updateCourse(courseID,updatCourseData);
    }

    //deleting your courses
    @DeleteMapping("/course/{cid}")
    public List<Course> deleteCourse(@PathVariable("cid") Integer courseID){
        return courseService.deleteCourse(courseID);
    }

    @PostMapping("/postcourse")
    public List<Course> postCourse(@RequestBody Course course) throws Exception{
        try{
         return courseService.postCourse(course);
    }
    catch(Exception exe){
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,exe.getMessage());
  }
}
}
