package com.example.learningmanagementsystemlab7.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherAssistantModel {

    @NotEmpty(message = "id is empty")
    private String id;

    @NotEmpty(message = "name is empty")
    private String name;

    @NotNull(message = "salary is null")
    private Integer salary;

    @NotEmpty(message = "bootcamp name is empty")
    private String bootcampName;


}
