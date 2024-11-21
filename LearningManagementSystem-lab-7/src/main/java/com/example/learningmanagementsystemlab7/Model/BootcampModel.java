package com.example.learningmanagementsystemlab7.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BootcampModel {

    @NotEmpty(message = "Bootcamp Name can't be empty")
    private String bootcampName;

    @NotEmpty(message = "Id is empty")
    private String id;

    @NotEmpty(message = "description is empty")
    private String description;

    @NotEmpty(message = "duration is empty")
    private String duration;

    @NotNull(message = "Start Date is null")
    private LocalDateTime startDate;

    @NotNull(message = "End Date is null")
    private LocalDateTime endDate;

}
