package com.SpringCourse.demo.Services.StudentServices;

import com.SpringCourse.demo.DTO.StudentDTOs.MinStudent;
import com.SpringCourse.demo.Model.StudentDB;
import com.SpringCourse.demo.Repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class StudentServices {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;


    public StudentServices(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;

    }


    public ResponseEntity <?> saveStudentMin(MinStudent StudentDTO) {
        try {
            StudentDB studentDB =  studentRepository.save(studentMapper.toStudentDB(StudentDTO));
        return new ResponseEntity<>(studentDB, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("bade request" , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity <?> saveStudent(StudentDB student) {
            try {

        return new ResponseEntity<>( studentRepository.save(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("bade request" , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
