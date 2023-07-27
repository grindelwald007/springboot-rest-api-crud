package com.CRUD.controller;

import com.CRUD.model.Student;
import com.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value="/dummy", method=RequestMethod.GET)
    public String loadApiHome(){
        return "dummy text on api page";
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value="/{studentId}", method=RequestMethod.GET)
    public Student getStudentById(@PathVariable(value="studentId")Long id){
        Optional<Student> tempStudent = studentService.getStudentById(id);
        if (tempStudent.isPresent()){
            return tempStudent.get();
        }
        else {
            ///throw exception
            return null;
        }

    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Student addStudent(@RequestBody Student newStudent){
        return studentService.addStudent(newStudent);
    }

    @RequestMapping(value="/{empId}", method=RequestMethod.PUT)
    public Student readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @RequestMapping(value="/{stdId}", method=RequestMethod.DELETE)
    public boolean removeStudent(@PathVariable(value = "stdId") Long id){
        return studentService.deleteStudent(id);
    }


    @RequestMapping(value="/{stdId}/take_course/{courseId}", method=RequestMethod.PUT)
    public Student takeCourse(
            @PathVariable(value = "stdId") Long stdId,
            @PathVariable(value = "courseId") Long courseId
    )
    {
        return studentService.takeCourse(stdId, courseId);
    }


}
