package com.manoo.hh_isell.presistance;

import com.manoo.hh_isell.model.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsers extends CrudRepository<Users,Integer> {


    Users findByUserName(String name);

    Users findByUserID(int id);
}
