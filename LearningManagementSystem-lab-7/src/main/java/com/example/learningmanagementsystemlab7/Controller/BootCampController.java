package com.example.learningmanagementsystemlab7.Controller;

import com.example.learningmanagementsystemlab7.ApiResponse.ApiResponse;
import com.example.learningmanagementsystemlab7.Model.BootcampModel;
import com.example.learningmanagementsystemlab7.Service.BootcampService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bootcamp")
@RequiredArgsConstructor
public class BootCampController {

    private final BootcampService bootcampService;

    @GetMapping("/get")
    public ResponseEntity<?> getBootcamps(){
        ArrayList<BootcampModel> bootcampModels = bootcampService.getBootcamps();
        return ResponseEntity.status(200).body(bootcampModels);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBootcamp(@RequestBody @Valid BootcampModel bootcampModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        bootcampService.addBootcamp(bootcampModel);
        return ResponseEntity.status(200).body(new ApiResponse("Bootcamp added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBootcamp(@PathVariable String id , @RequestBody @Valid BootcampModel bootcampModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate = bootcampService.updateBootcamp(id, bootcampModel);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("bootcamp updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("bootcamp not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBootcamp(@PathVariable String id){
        boolean isDeleted = bootcampService.deleteBootcamp(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("bootcamp deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("bootcamp not found"));
    }

}
