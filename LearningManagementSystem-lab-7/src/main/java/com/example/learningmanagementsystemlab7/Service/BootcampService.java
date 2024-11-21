package com.example.learningmanagementsystemlab7.Service;

import com.example.learningmanagementsystemlab7.Model.BootcampModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BootcampService {

    ArrayList<BootcampModel> bootcamps = new ArrayList<>();

    public ArrayList<BootcampModel> getBootcamps(){
        return bootcamps;
    }

    public void addBootcamp(BootcampModel bootcampModel){
        bootcamps.add(bootcampModel);
    }

    public boolean updateBootcamp(String id , BootcampModel bootcampModel){
        for (int i = 0; i < bootcamps.size(); i++) {
            if(bootcamps.get(i).getId().equals(id)){
                bootcamps.set(i,bootcampModel);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBootcamp(String id){
        for (int i = 0; i < bootcamps.size(); i++) {
            if(bootcamps.get(i).getId().equals(id)){
                bootcamps.remove(i);
                return true;
            }
        }
        return false;
    }
}
