package com.example.learningmanagementsystemlab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {

    @NotEmpty(message = "id is empty")
    private String id;

    @NotEmpty(message = "National ID is empty")
    @Size(min = 10, max = 10 , message = "id length is 10 digits exactly")
    @Pattern(regexp = "^1\\d{9}$", message = "ID must start with '1' and be exactly 10 digits long.")
    private String nationalID;

    @NotEmpty(message = "Name is Empty")
    @Size(max = 20 , message = "Name length can't be more than 20 characters")
    private String name;

    @NotBlank(message = "Email is blank")
    @Email(message = "Enter a valid email format")
    private String email;

    @NotNull(message = "Age can't be null")
    @Min(22)
    @Max(35)
    private Integer age;

    @AssertFalse(message = "You should have Bachelor In Technical Major")
    private boolean bachelorInTechnicalMajor;

    @NotEmpty(message = "bootcampName is empty")
    private String bootcampName;
}
