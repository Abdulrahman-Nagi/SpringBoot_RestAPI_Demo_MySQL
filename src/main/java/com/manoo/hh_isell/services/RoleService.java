package com.manoo.hh_isell.services;

import com.manoo.hh_isell.exceptionhandling.exceptions.NotFoundException;
import com.manoo.hh_isell.model.Roles;
import com.manoo.hh_isell.presistance.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IRole rolesRepo;


    public void addRole(Roles role) {


        rolesRepo.save(role);

    }








    public Roles findByID(int roleid) {

      if(rolesRepo.findById(roleid).isPresent()) {

          return rolesRepo.findById(roleid).get();
      }
else {

    throw new NotFoundException(String.format("There is nor Role with ID [%s] Found",roleid));
      }

    }
}
