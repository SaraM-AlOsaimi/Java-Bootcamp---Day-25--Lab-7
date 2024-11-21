package com.example.learningmanagementsystemlab7.Controller;

import com.example.learningmanagementsystemlab7.ApiResponse.ApiResponse;
import com.example.learningmanagementsystemlab7.Model.InstructorModel;
import com.example.learningmanagementsystemlab7.Model.StudentModel;
import com.example.learningmanagementsystemlab7.Service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/get")
    public ResponseEntity<?> getInstructors(){
        return ResponseEntity.status(200).body(instructorService.getInstructors());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addInstructor(@RequestBody @Valid InstructorModel instructorModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        instructorService.addInstructor(instructorModel);
        return ResponseEntity.status(200).body(new ApiResponse("Instructor added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable String id , @RequestBody @Valid InstructorModel instructorModel, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate = instructorService.updateInstructor(id,instructorModel);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Instructor Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable String id){
        boolean isDelete = instructorService.deleteInstructor(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("Instructor Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @GetMapping("/get/instructor/{bootcampName}")
    public ResponseEntity<?> getInstructorByBootcamp(@PathVariable String bootcampName) {
        InstructorModel instructor = instructorService.getInstructorByBootcamp(bootcampName);
        if (instructor != null) {
            return ResponseEntity.status(200).body(instructor);
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("Instructor not found for this bootcamp"));
        }
    }

    @PutMapping("/annual/leave/{id}")
    public ResponseEntity<?> takeAnnualLeave(@PathVariable String id) {
boolean isAnnualLeave = instructorService.takeAnnualLeave(id);
if (isAnnualLeave){
    return ResponseEntity.status(200).body(new ApiResponse("Annual leave applied"));
}
return ResponseEntity.status(400).body(new ApiResponse("ID not found or you have used all your annual leave days"));

    }

    @GetMapping("/search/by/id/{id}")
    public ResponseEntity<?> searchByInstructorByID(@PathVariable String id){
        InstructorModel instructorModel = instructorService.searchByInstructorByID(id);
        if(instructorModel == null){
            return ResponseEntity.status(400).body(new ApiResponse("no instructor with given id found"));
        } else return ResponseEntity.status(200).body(instructorModel);

    }

    @PutMapping("/calculate/bonus/{id}/{bonus}")
    public ResponseEntity<?> calculateBonusSalary(@PathVariable String id , @PathVariable int bonus){
        InstructorModel instructorModel = instructorService.calculateBonusSalary(id, bonus);
        if(instructorModel == null){
            return ResponseEntity.status(400).body(new ApiResponse("no instructor with given id found"));
        }
        return ResponseEntity.status(200).body(instructorModel);
    }

}

