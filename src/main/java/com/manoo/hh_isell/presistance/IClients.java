package com.manoo.hh_isell.presistance;



import com.manoo.hh_isell.model.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IClients extends CrudRepository<Clients,Long> {







}
