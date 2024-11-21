package com.example.learningmanagementsystemlab7.Controller;

import com.example.learningmanagementsystemlab7.ApiResponse.ApiResponse;
import com.example.learningmanagementsystemlab7.Model.StudentModel;
import com.example.learningmanagementsystemlab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService ;

    //  create CRUD operations and four endpoints that have logic


    @GetMapping("/get")
    public ResponseEntity<?> getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid StudentModel studentModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        studentService.addStudent(studentModel);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id , @RequestBody @Valid StudentModel studentModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate = studentService.updateStudent(id, studentModel);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Student information is updated"));
        }
 return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }

    @PutMapping("/update/major/status/{id}")
 public ResponseEntity<?> UpdateTechnicalMajorStatus(@PathVariable String id){
     boolean isFound = studentService.UpdateTechnicalMajorStatus(id);
     if(isFound){
         return ResponseEntity.status(200).body(new ApiResponse("Technical Major Status updated"));
     } else return ResponseEntity.status(400).body(new ApiResponse("ID not found"));
}

@GetMapping("/get/student/by/bootcamp/{bootcampName}")
 public ResponseEntity<?> getStudentsByBootcamp(@PathVariable String bootcampName){
        ArrayList studentByBootcamp = studentService.getStudentsByBootcamp(bootcampName);
     if(studentByBootcamp == null){
         return ResponseEntity.status(400).body(new ApiResponse("No student in that bootcamp"));
    }
     return ResponseEntity.status(200).body(studentByBootcamp);
}


@GetMapping("/search/by/id/{id}")
public ResponseEntity<?> searchStudentByID(@PathVariable String id){
    StudentModel student = studentService.searchStudentByID(id);
    if(student == null){
        return ResponseEntity.status(400).body(new ApiResponse("no Student with given id found"));
    } else return ResponseEntity.status(200).body(student);

}


    @GetMapping("/age/range/{minAge}/{maxAge}")
    public ResponseEntity<?> getStudentsByAgeRange(@PathVariable int minAge, @PathVariable int maxAge) {
        ArrayList<StudentModel> studentsInRange = studentService.getStudentsByAgeRange(minAge, maxAge);
        if (studentsInRange.isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("No students found in this age range"));
        }
        return ResponseEntity.status(200).body(studentsInRange);
    }


}
