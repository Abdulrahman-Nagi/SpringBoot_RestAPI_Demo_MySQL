package com.manoo.hh_isell.services;


import com.manoo.hh_isell.exceptionhandling.exceptions.NotFoundException;
import com.manoo.hh_isell.model.Clients;
import com.manoo.hh_isell.presistance.IClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    IClients clientRepo;


    public Clients saveClient(Clients client) {

     return    clientRepo.save(client);
    }




    public List<Clients> getAllClients() {

        return (List<Clients>) clientRepo.findAll();
    }






    public Clients findByID(long id) {

        if( clientRepo.findById(id).isPresent()) {

            return clientRepo.findById(id).get();
        }

        else {

            throw  new NotFoundException(String.format("Client with Code [%s] Not found",id));
        }
    }
}
