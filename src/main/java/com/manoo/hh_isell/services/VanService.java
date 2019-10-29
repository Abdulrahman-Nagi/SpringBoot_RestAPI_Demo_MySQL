package com.manoo.hh_isell.services;


import com.manoo.hh_isell.model.Van;
import com.manoo.hh_isell.presistance.Ivan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanService {

    @Autowired
    Ivan ivan;

    public void saveVan(Van van) {

        ivan.save(van);

    }


    public List<Van> getAllVans() {

        return (List<Van>) ivan.findAll();
    }

    public Optional<Van> getVanByID(long vID){

       return ivan.findById(vID);
    }

}
