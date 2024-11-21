package com.example.learningmanagementsystemlab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstructorModel {

    @NotEmpty(message = "id is empty")
    private String id;

    @NotEmpty(message = "employeeID is Empty")
    @Size(max = 10)
    private String employeeID;

    @NotEmpty(message = "name is empty")
    @Size(max = 20 , message = "name length can't be more than 20 characters")
    private String name;

    @NotBlank(message = "Email is blank")
    @Email(message = "Enter a valid email format")
    private String email;


    @NotEmpty(message = "bootcamp name is empty")
    private String bootcampName;


    @NotNull(message = "salary is null")
    private Integer salary;

    @NotNull(message = "annual Leave Days is null")
    @Positive
    private Integer annualLeaveDays;

    @AssertFalse(message = "On leave must be false")
    private boolean onLeave;

}
