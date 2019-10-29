package com.manoo.hh_isell.controllers;


import com.manoo.hh_isell.model.SalesRep;
import com.manoo.hh_isell.services.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesRepController {

    @Autowired
    SalesRepService salesRepService;



    @PostMapping(value = "/secured/salesrep")
    public ResponseEntity<SalesRep> saveSalesRep(@RequestBody SalesRep salesRep) {

        SalesRep sR=  salesRepService.saveSalesRep(salesRep);

        return new ResponseEntity<SalesRep>(sR, HttpStatus.CREATED); }

}
