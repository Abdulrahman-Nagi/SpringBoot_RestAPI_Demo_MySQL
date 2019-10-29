package com.manoo.hh_isell.presistance;

import com.manoo.hh_isell.model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRole extends CrudRepository<Roles,Integer> {

}
