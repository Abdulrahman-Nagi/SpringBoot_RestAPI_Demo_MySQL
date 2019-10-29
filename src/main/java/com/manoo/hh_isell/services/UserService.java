package com.manoo.hh_isell.services;


import com.manoo.hh_isell.exceptionhandling.exceptions.ConflictException;
import com.manoo.hh_isell.exceptionhandling.exceptions.NotFoundException;
import com.manoo.hh_isell.model.CustomUserDetails;
import com.manoo.hh_isell.model.Roles;
import com.manoo.hh_isell.model.Users;
import com.manoo.hh_isell.presistance.IUsers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Service
public class UserService implements UserDetailsService {


    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    IUsers usersRepo;



    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Users user = usersRepo.findByUserName(username);

        Set<Roles> roles = user.getRoles();
        logger.debug("role of the user" + roles);

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Roles role: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
            logger.debug("role" + role + " role.getRole()" + (role.getRole()));
        }

        CustomUserDetails customUserDetail=new CustomUserDetails();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(authorities);

        return customUserDetail;
    }



    public void saveNewUser(Users user) {


        if(usersRepo.findByUserName(user.getUserName())!=null) {

            throw new ConflictException(String.format("The user [%s] already exist",user.getUserName()));
        }

        else {

            user.setPassword(passwordEncoder().encode(user.getPassword()));

            usersRepo.save(user);

        }
    }





    public List<Users> findAllUsers() {

        return (List<Users>) usersRepo.findAll();
    }



   public Users findUserByName(String name) {

     return    usersRepo.findByUserName(name);
}





public void updateUser(Users user) {

        usersRepo.save(user);
}




public Users findById(int id) {


        if( usersRepo.findById(id).isPresent()){

            return usersRepo.findById(id).get();
        }

        else {

            throw  new NotFoundException(String.format("User with ID [%s] not found",id));
        }


}



}
