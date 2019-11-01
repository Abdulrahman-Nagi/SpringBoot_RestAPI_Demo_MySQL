package com.manoo.hh_isell.controllers;

import com.manoo.hh_isell.model.SalesRep;
import com.manoo.hh_isell.model.Van;
import com.manoo.hh_isell.services.SalesRepService;
import com.manoo.hh_isell.services.VanService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/van")
public class VanController {

    @Autowired
    VanService vanService;

    @Autowired
    SalesRepService salesRepService;


    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Van>> getAllVans() {

        List<Van> allVans = vanService.getAllVans();

        return new ResponseEntity<List<Van>>(allVans, HttpStatus.OK);
    }



    @PostMapping(value = "/create")
    public ResponseEntity<Van> saveNewVan(@Valid @RequestBody Van van) {

        vanService.saveVan(van);

        return new ResponseEntity<Van>(van,HttpStatus.CREATED);
    }



    @PutMapping(value = "{vanid}/{srid}/assign")
    public ResponseEntity<Van> assignSalesrep(@PathVariable long vanid,@PathVariable long srid){

        SalesRep sR = salesRepService.findByID(srid);

        Van van = vanService.getVanByID(vanid);

        van.setSalesRep(sR);

      Van saved =  vanService.updateVan(van);

        return new ResponseEntity<Van>(saved,HttpStatus.OK);
    }




    @PutMapping("{vanid}/unassign")
    public ResponseEntity<Van> unassingSalesRep (@PathVariable long vanid) {

        Van van =vanService.getVanByID(vanid);

        van.setSalesRep(null);

        Van saved =vanService.updateVan(van);

        return new ResponseEntity<Van>(saved,HttpStatus.OK);

    }


}
