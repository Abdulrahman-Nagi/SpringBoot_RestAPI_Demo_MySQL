package com.manoo.hh_isell.presistance;


import com.manoo.hh_isell.model.Van;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ivan extends CrudRepository<Van,Long> {
}
