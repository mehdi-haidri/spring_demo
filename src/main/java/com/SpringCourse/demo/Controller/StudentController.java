package com.SpringCourse.demo.Controller;
import com.SpringCourse.demo.DTO.StudentDTOs.MinStudent;
import com.SpringCourse.demo.Repositories.StudentRepository;
import com.SpringCourse.demo.Model.StudentDB;
import com.SpringCourse.demo.Services.StudentServices.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentServices studentServices;



    public StudentController(StudentRepository studentRepository, StudentServices studentServices) {
        this.studentRepository = studentRepository;
        this.studentServices = studentServices;
    }



    @PostMapping("/student_min")

    public ResponseEntity<?> saveStudentMin(
            @RequestBody MinStudent StudentDTO
    ){
            return studentServices.saveStudentMin(StudentDTO);
    }

    @PostMapping("/student")
    public ResponseEntity<?> saveStudent(
            @RequestBody StudentDB student
    ){
            return studentServices.saveStudent(student);
    }


    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDB> getStudents()
    {
        return studentRepository.findAll();
    }



    @GetMapping("/students/{student_id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDB getStudent(
            @PathVariable Integer student_id
    ){

        return studentRepository.findById(student_id).orElse(new StudentDB());
    }


}
