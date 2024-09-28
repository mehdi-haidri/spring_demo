package com.SpringCourse.demo.Controller;
import com.SpringCourse.demo.DTO.StudentDTOs.MinStudent;
import com.SpringCourse.demo.Repositories.StudentRepository;
import com.SpringCourse.demo.Model.StudentDB;
import com.SpringCourse.demo.Services.StudentServices.StudentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {


    private final StudentServices studentServices;



    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }



    @PostMapping("/student_min")

    public ResponseEntity<?> saveStudentMin(
            @Valid @RequestBody MinStudent StudentDTO
    ){
            return studentServices.saveStudentMin(StudentDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private  ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        HashMap<String , String> errors = new HashMap<>();
        exp.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var  fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
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
        return (List<StudentDB>) studentServices.findAllStudents();
    }



    @GetMapping("/students/{student_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getStudent(
            @PathVariable Integer student_id
    ){

        return studentServices.findStudentById(student_id);
    }
    @GetMapping("/delete_students/{student_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteStudent(
            @PathVariable("student_id") Integer id
    ){

        return studentServices.deleteStudent(id);
    }


}