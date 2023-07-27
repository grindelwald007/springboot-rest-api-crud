package com.CRUD.service;


import com.CRUD.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student addStudent(Student newStudent);
    public List<Student> getAllStudents();

    public Optional<Student> getStudentById(Long id);

    public Student updateStudent(Long id, Student studentDetails);

    public boolean deleteStudent(Long id);

    public Student takeCourse(Long stdId, Long courseId);
}
