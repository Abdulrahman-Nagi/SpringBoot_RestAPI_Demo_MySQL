package com.manoo.hh_isell.model;


import javax.persistence.*;

import java.util.List;


@Entity
public class SalesRep {

    @Id
    @Column(name ="SalesRep_Code")
    private long salesRepCode;

    @Column(name = "SalesRep_Name")
    private String salesRepName;



    @OneToMany(mappedBy = "salesRep",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Clients> salesRepClients;




    @OneToOne(mappedBy = "salesRep")
    private Van salesRepVan;



    public long getSalesRepCode() {
        return salesRepCode;
    }

    public void setSalesRepCode(long salesRepCode) {
        this.salesRepCode = salesRepCode;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    public List<Clients> getSalesRepClients() {
        return salesRepClients;
    }

    public void setSalesRepClients(List<Clients> salesRepClients) {
        this.salesRepClients = salesRepClients;
    }
}
