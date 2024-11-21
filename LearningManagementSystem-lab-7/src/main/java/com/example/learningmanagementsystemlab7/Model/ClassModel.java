package com.example.learningmanagementsystemlab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassModel {

    @NotEmpty(message = "Class name is Empty")
    private String name;

    @NotEmpty(message = "floor is Empty")
    @Pattern(regexp = "^First floor | Second floor$")
    private String floor;

    @NotNull(message = "Class Capacity is null")
    @Positive(message = "Class Capacity must be positive")
    private Integer classCapacity;

    @AssertFalse(message = "must be false")
    private boolean occupied;

}
