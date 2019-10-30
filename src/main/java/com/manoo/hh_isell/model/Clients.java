package com.manoo.hh_isell.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import java.util.Date;


@Entity
public class Clients {

    @Id
    @Range(min = 6,message = "Client code shouldn't be less than 6 digits")
   private long client_code;

    @NotEmpty
    private String client_name;

    @NotEmpty
    private String client_location;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "sales_rep_Code",nullable = false)
    @JsonIgnore
    private SalesRep salesRep;


    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyy hh:mm")
    private Date  created_at;


    public Clients() {

        this.created_at=new Date();
    }



    public long getClient_code() {
        return client_code;
    }

    public void setClient_code(long client_code) {
        this.client_code = client_code;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_location() {
        return client_location;
    }

    public void setClient_location(String client_location) {
        this.client_location = client_location;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


}
