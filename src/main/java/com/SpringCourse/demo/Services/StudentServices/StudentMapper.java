package com.SpringCourse.demo.Services.StudentServices;

import com.SpringCourse.demo.DTO.StudentDTOs.MinStudent;
import com.SpringCourse.demo.Model.School;
import com.SpringCourse.demo.Model.StudentDB;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentDB toStudentDB(MinStudent minStudent){

        StudentDB studentDB = new StudentDB();
        School school = new School();
        school.setId(minStudent.schoolId());
        studentDB.setName(minStudent.name());
        studentDB.setEmail(minStudent.email());
        studentDB.setSchool(school);
        return studentDB;

    }



}
