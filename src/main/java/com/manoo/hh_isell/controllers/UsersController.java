package com.manoo.hh_isell.controllers;


import com.manoo.hh_isell.model.CustomUserDetails;
import com.manoo.hh_isell.model.Roles;
import com.manoo.hh_isell.model.Users;
import com.manoo.hh_isell.services.RoleService;
import com.manoo.hh_isell.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;




    @PostMapping(value = "/signup")
    ResponseEntity<Users> signUp( @Valid @RequestBody Users user) {

        userService.saveNewUser(user);

        return new ResponseEntity<Users>(HttpStatus.CREATED);
    }




    @GetMapping(value = "/active")
    ResponseEntity<String> getActiveSession(){

        Object u =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String activeUser=null;

        Set<GrantedAuthority> authorities=null;
        if(u instanceof CustomUserDetails) {

            activeUser = ((CustomUserDetails) u).getUsername();

            authorities= (Set<GrantedAuthority>) ((CustomUserDetails) u).getAuthorities();

        }

        else  {

            activeUser= u.toString();
        }

        return new ResponseEntity<String>(activeUser +"---"+ authorities,HttpStatus.OK);
    }






    @GetMapping(value = "/all")
    ResponseEntity<List<Users>> getAllUsers(){

        List<Users> allUsers =userService.findAllUsers();

        return new ResponseEntity<List<Users>>(allUsers,HttpStatus.OK);
    }



    @PostMapping(value = "/addrole")
    ResponseEntity<Roles> addRole(@RequestBody Roles role) {


        roleService.addRole(role);

        return new ResponseEntity<Roles>(role,HttpStatus.CREATED);
    }





    @PutMapping(value = "/{userid}/{roleid}/updaterole")
    ResponseEntity<Users> updateUserRole(@PathVariable(value = "userid") int userid ,@PathVariable (value = "roleid") int roleid) {

        Roles role = roleService.findByID(roleid);

        Users u = userService.findById(userid);

        u.getRoles().add(role);

        u.setRoles(u.getRoles());

        userService.updateUser(u);


        return new ResponseEntity<Users>(u,HttpStatus.OK);

    }
}
