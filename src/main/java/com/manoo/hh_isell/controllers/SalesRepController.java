package com.manoo.hh_isell.controllers;


import com.manoo.hh_isell.model.SalesRep;
import com.manoo.hh_isell.services.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salesrep")
public class SalesRepController {

    @Autowired
    SalesRepService salesRepService;



    @PostMapping(value = "/add")
    public ResponseEntity<SalesRep> saveSalesRep(@RequestBody SalesRep salesRep) {

        SalesRep sR=  salesRepService.saveSalesRep(salesRep);

        return new ResponseEntity<SalesRep>(sR, HttpStatus.CREATED); }





        @GetMapping(value = "/all")
        public ResponseEntity<List<SalesRep>> getAll(){

            List<SalesRep> allSalesrep =salesRepService.getAllSalesReps();

            return new ResponseEntity<List<SalesRep>>(allSalesrep,HttpStatus.OK);
         }

}
