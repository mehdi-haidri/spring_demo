package com.SpringCourse.demo.DTO.SchoolDTOs;

public class MinSchoolResponse {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public MinSchoolResponse(String name) {
        this.name = name;
    }

}
