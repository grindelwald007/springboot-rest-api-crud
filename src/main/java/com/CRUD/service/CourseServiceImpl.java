package com.CRUD.service;

import com.CRUD.model.Course;
import com.CRUD.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepo courseRepo;
    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    @Override
    public List<Course> addCourse(Course course) {

        courseRepo.save(course);

        return courseRepo.findAll();
    }


}
