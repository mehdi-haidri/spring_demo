package com.SpringCourse.demo.Controller;


import com.SpringCourse.demo.Model.School;

import com.SpringCourse.demo.Services.SchoolServices.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SchoolController {


    private  final SchoolService schoolService;

    public SchoolController(SchoolService schoolService)  {
        this.schoolService = schoolService;
    }

    @PostMapping("/school")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> saveSchool(
            @RequestBody School school
    ){
            return schoolService.saveSchool(school);

    }


    @GetMapping("/school/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getSchool(
            @PathVariable Integer id
    ){

            return schoolService.findSchoolById(id);

    }



    @GetMapping("/schools")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getSchools(){
        return schoolService.findAllSchools();
    }

}
