package com.manoo.hh_isell.services;


import com.manoo.hh_isell.exceptionhandling.exceptions.ConflictException;
import com.manoo.hh_isell.exceptionhandling.exceptions.NotFoundException;
import com.manoo.hh_isell.model.Van;
import com.manoo.hh_isell.presistance.Ivan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanService {

    @Autowired
    Ivan vanRepo;



    public Van saveVan(Van van) {


        if(!vanRepo.findById(van.getVanID()).isPresent()){

        return     vanRepo.save(van);

        }

        else {

            throw new ConflictException(String.format("Van with Code [%s] Already exist",van.getVanID()));
        }

    }



    public Van updateVan(Van van){

      return   vanRepo.save(van);
    }


    public List<Van> getAllVans() {

        return (List<Van>) vanRepo.findAll();
    }




    public Van getVanByID(long vID){

       if(!vanRepo.findById(vID).isPresent()){

           throw new NotFoundException(String.format("Van with code [%s] not found",vID));
       }
       else {

           return vanRepo.findById(vID).get();
       }
    }

}
