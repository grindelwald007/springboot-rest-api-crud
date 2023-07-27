package com.CRUD.service;

import com.CRUD.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    List<Course> addCourse(Course course);

}
