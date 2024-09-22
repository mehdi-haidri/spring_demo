package com.SpringCourse.demo.Repositories;

import com.SpringCourse.demo.Model.StudentDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDB, Integer> {

}
