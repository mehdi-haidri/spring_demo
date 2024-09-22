package com.SpringCourse.demo.Controller;

import com.SpringCourse.demo.DTO.SchoolDTOs.MinSchoolResponse;
import com.SpringCourse.demo.Model.School;
import com.SpringCourse.demo.Repositories.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private  final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/school")
    @ResponseStatus(HttpStatus.OK)
    public Object saveSchool(
            @RequestBody School school
    ){
        try {

            return schoolRepository.save(school);

        }catch(Exception e){
            return e;
        }
    }


    @GetMapping("/school/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getSchool(
            @PathVariable Integer id
    ){
        try {

            return schoolRepository.findById(id);

        }catch(Exception e){
            return e;
        }
    }


    private MinSchoolResponse toMinSchoolResponse(School school){
        return new MinSchoolResponse(school.getName());
    }


    @GetMapping("/schools")
    @ResponseStatus(HttpStatus.OK)
    public List<MinSchoolResponse> getSchools(){

        return schoolRepository.findAll()
                .stream()
                .map(this::toMinSchoolResponse)
                .collect(Collectors.toList());
    }

}
