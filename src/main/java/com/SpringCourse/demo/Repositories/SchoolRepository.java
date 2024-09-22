package com.SpringCourse.demo.Repositories;

import com.SpringCourse.demo.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
