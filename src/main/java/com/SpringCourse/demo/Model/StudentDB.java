package com.SpringCourse.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentDB {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Integer Id;
        private String name;
        private int age;
        @Column(unique=true , nullable = false)
        private String email;
        @ManyToOne
        @JoinColumn(
            name = "school_id"
        )
        @JsonBackReference
        private School school;



    public void setSchool(School school) {
        this.school = school;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public School getSchool() {
        return school;
    }
    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
