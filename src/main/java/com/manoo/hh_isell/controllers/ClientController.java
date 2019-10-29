package com.manoo.hh_isell.controllers;


import com.manoo.hh_isell.model.Clients;
import com.manoo.hh_isell.model.SalesRep;
import com.manoo.hh_isell.services.ClientService;
import com.manoo.hh_isell.services.SalesRepService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    SalesRepService salesRepService;



    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Clients>> getAllClients() {

        List<Clients> allClients =clientService.getAllClients();

        return new ResponseEntity<List<Clients>>(allClients,HttpStatus.OK);
    }



    @PostMapping("/{salesrepid}")
    public ResponseEntity<Clients> addClient(@PathVariable(value = "salesrepid") long id, @RequestBody Clients client) {




return new ResponseEntity<Clients>( HttpStatus.CREATED);
    }



    @PutMapping("/{salesrepid}/{clientid}")
    public ResponseEntity<SalesRep> updateSalesrepClient(@PathVariable(value = "salesrepid") long srid ,

      @PathVariable (value = "clientid") long cid ) {

        SalesRep sr = salesRepService.findByID(srid);

        Clients c = clientService.findByID(cid);

        c.setSalesRep(sr);

        clientService.saveClient(c);


    return new ResponseEntity<SalesRep>(sr,HttpStatus.OK);}





    @PostMapping(value = "/secured/client")
    public ResponseEntity<Clients> saveClient(@Valid @RequestBody Clients client) {

      Clients clients=  clientService.saveClient(client);

        return new ResponseEntity<Clients>(clients,HttpStatus.CREATED);
    }



}
