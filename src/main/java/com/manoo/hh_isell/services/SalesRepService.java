package com.manoo.hh_isell.services;


import com.manoo.hh_isell.exceptionhandling.exceptions.ConflictException;

import com.manoo.hh_isell.exceptionhandling.exceptions.NotFoundException;
import com.manoo.hh_isell.model.SalesRep;
import com.manoo.hh_isell.presistance.ISalesRep;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SalesRepService {

    @Autowired
    ISalesRep salesRepRepo;



    public SalesRep saveSalesRep(SalesRep salesRep) {


            if(!salesRepRepo.findById(salesRep.getSalesRepCode()).isPresent()) {

                return salesRepRepo.save(salesRep);

            } else {

                throw new ConflictException(String.format("Sales Rep with code : [%s]  already exists",salesRep.getSalesRepCode()));

            }
    }




    public List<SalesRep> getAllSalesReps() {

        return (List<SalesRep>) salesRepRepo.findAll();
    }


    public SalesRep findByID(long id)  {

        if(salesRepRepo.findById(id).isPresent()) {

            return salesRepRepo.findById(id).get();
        } else {

            throw new NotFoundException(String.format("Sales Rep with Code [%s] Not Found",id));

        }

    }



}
