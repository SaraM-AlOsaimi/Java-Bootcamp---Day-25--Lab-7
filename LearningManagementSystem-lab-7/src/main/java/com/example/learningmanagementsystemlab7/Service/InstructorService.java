package com.example.learningmanagementsystemlab7.Service;

import com.example.learningmanagementsystemlab7.Model.InstructorModel;
import com.example.learningmanagementsystemlab7.Model.StudentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstructorService {

    ArrayList<InstructorModel> instructors = new ArrayList<>();


    public ArrayList<InstructorModel> getInstructors(){
        return instructors;
    }

    public void addInstructor(InstructorModel instructorModel){
        instructors.add(instructorModel);
    }

    public boolean updateInstructor(String id , InstructorModel instructorModel){
        for (int i = 0; i < instructors.size(); i++) {
           if(instructors.get(i).getId().equals(id)){
               instructors.set(i,instructorModel);
               return true;
           }
        }
        return false;
    }

    public boolean deleteInstructor(String id){
        for (int i = 0; i < instructors.size(); i++) {
           if(instructors.get(i).getId().equals(id)){
               instructors.remove(i);
               return true;
           }
        }
        return false;
    }

public InstructorModel getInstructorByBootcamp(String bootcampName) {
    for (InstructorModel instructor : instructors) {
        if (instructor.getBootcampName().equals(bootcampName)) {
            return instructor;
        }
    }
    return null;
}

public boolean takeAnnualLeave(String id) {
    for (InstructorModel instructorModel : instructors) {
        if (instructorModel.getId().equals(id) && !instructorModel.isOnLeave() && instructorModel.getAnnualLeaveDays() > 0) {
            instructorModel.setOnLeave(true);
            instructorModel.setAnnualLeaveDays(instructorModel.getAnnualLeaveDays() - 1);
            return true;
        }
    }
    return false;
 }

    public InstructorModel searchByInstructorByID(String id){
        for (InstructorModel instructor : instructors) {
            if(instructor.getId().equals(id)){
                return instructor;
            }
        }
        return null;
    }

    // calculateBonusSalary(in id, in bouns): InstructorModel

    public InstructorModel calculateBonusSalary(String id , int bonus){
        for (int i = 0; i < instructors.size(); i++) {
            InstructorModel instructor = instructors.get(i);
            if(instructor.getId().equals(id)){
                instructor.setSalary(instructor.getSalary() + bonus);
                return instructor;
            }
        }
        return null;
    }


}
