package com.SpringCourse.demo.Services.SchoolServices;

import com.SpringCourse.demo.DTO.SchoolDTOs.MinSchoolResponse;
import com.SpringCourse.demo.Model.School;
import com.SpringCourse.demo.Repositories.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class SchoolService {

    private  final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    public ResponseEntity<?> saveSchool(School school){
        try {

            return new ResponseEntity<>( schoolRepository.save(school)  , HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>( "bad Request"  , HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findSchoolById(Integer id){
        try {

            return new ResponseEntity<>( schoolRepository.findById(id).orElse(new School()) , HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>( "bad request", HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<?> findAllSchools(){
        try {

            return new ResponseEntity<>( schoolRepository.findAll().stream()
                    .map(this::toMinSchoolResponse)
                    .collect(Collectors.toList()), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>( "bad request", HttpStatus.BAD_REQUEST);

        }
    }

    private MinSchoolResponse toMinSchoolResponse(School school){
        return new MinSchoolResponse(school.getName());
    }
}
