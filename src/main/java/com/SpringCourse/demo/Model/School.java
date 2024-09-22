package com.SpringCourse.demo.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;


    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<StudentDB> students ;

    public List<StudentDB> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDB> students) {
        this.students = students;
    }

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
