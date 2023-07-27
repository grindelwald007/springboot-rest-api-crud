package com.CRUD.controller;

import com.CRUD.model.Course;
import com.CRUD.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/courses")
public class CourseController {

    private CourseServiceImpl courseService;
    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public List<Course> addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

}
