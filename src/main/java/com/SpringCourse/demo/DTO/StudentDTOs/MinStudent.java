package com.SpringCourse.demo.DTO.StudentDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MinStudent(
        @NotNull
        @Size(min = 1, max = 10)
        String name,
        @NotNull
        String email,
        Integer schoolId
) {
}
