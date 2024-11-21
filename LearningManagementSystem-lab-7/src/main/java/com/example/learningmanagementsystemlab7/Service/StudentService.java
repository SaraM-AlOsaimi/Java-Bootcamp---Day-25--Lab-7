package com.example.learningmanagementsystemlab7.Service;

import com.example.learningmanagementsystemlab7.Model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<StudentModel> students = new ArrayList<>();

    // methods:
    // get
   public ArrayList<StudentModel> getStudents(){
    return students;
  }

  public void addStudent(StudentModel studentModel){
       students.add(studentModel);
  }

  public boolean updateStudent(String id , StudentModel studentModel){
      for (int i = 0; i < students.size(); i++) {
          if(students.get(i).getId().equals(id)){
              students.set(i,studentModel);
              return true;
          }
      }
      return false;
  }

  public boolean deleteStudent(String id){
      for (int i = 0; i < students.size(); i++) {
          if(students.get(i).getId().equals(id)){
              students.remove(i);
              return true;
          }
      }
      return false;
  }


  public boolean UpdateTechnicalMajorStatus(String id){
      for (StudentModel studentModel : students) {
          if(studentModel.getId().equals(id) && !studentModel.isBachelorInTechnicalMajor()) {
          studentModel.setBachelorInTechnicalMajor(true);
          return true;
      }
     }
    return false;
      }





    // getStudentsByBootcamp(bootcampName): arrayList
    public ArrayList<StudentModel> getStudentsByBootcamp(String bootcampName){
       ArrayList<StudentModel> studentsByBootcampName = new ArrayList<>();
       for (StudentModel studentModel : students){
           if (studentModel.getBootcampName().equals(bootcampName)){
               studentsByBootcampName.add(studentModel);

           }
       }
        return studentsByBootcampName.isEmpty() ? null : studentsByBootcampName;
    }


    // searchStudentByID(id): object
    public StudentModel searchStudentByID(String id){
        for (StudentModel studentModel : students) {
            if(studentModel.getId().equals(id)){
                return studentModel;
            }
        }
        return null;
    }


    public ArrayList<StudentModel> getStudentsByAgeRange(int minAge, int maxAge) {
        ArrayList<StudentModel> studentsInRange = new ArrayList<>();
        for (StudentModel studentModel : students) {
            if (studentModel.getAge() >= minAge && studentModel.getAge() <= maxAge) {
                studentsInRange.add(studentModel);
            }
        }
        return studentsInRange.isEmpty() ? null : studentsInRange;
    }

}
