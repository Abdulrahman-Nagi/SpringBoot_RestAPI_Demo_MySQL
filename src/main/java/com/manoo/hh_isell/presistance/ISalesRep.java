package com.manoo.hh_isell.presistance;

import com.manoo.hh_isell.model.SalesRep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISalesRep extends CrudRepository<SalesRep,Long> {


}
