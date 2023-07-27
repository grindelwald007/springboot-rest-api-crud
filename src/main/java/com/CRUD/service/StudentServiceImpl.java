package com.CRUD.service;

import com.CRUD.model.Course;
import com.CRUD.model.Student;
import com.CRUD.repository.CourseRepo;
import com.CRUD.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepo studentRepo;
    private CourseRepo courseRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Student addStudent(Student newStudent) {
        return studentRepo.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Student student = studentRepo.findById(id).get();

        if (student != null) {
            student.setName(updateStudent.getName());
//            student.setEmail(updateStudent.getEmail());
            studentRepo.save(student);
        }
        return student;
    }

    @Override
    public boolean deleteStudent(Long id) {
        Student student = studentRepo.findById(id).get();

        if (student != null){
            studentRepo.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public Student takeCourse(Long stdId, Long courseId) {
        Student student = studentRepo.findById(stdId).get();
        Course course = courseRepo.findById(courseId).get();

        Set<Course> courses = null;

        if (student != null && course != null){
            courses = student.getLikedCourses();
            courses.add(course);
            student.setLikedCourses(courses);
            return studentRepo.save(student);
        }
        else {
            //handle exception later
        }
        return student;
    }


}



