package com.manoo.hh_isell.model;


import javax.persistence.*;

@Entity
public class Van {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "van_ID")
    private long vanID;

    private String vanModel;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SalesRep_Code")
    private SalesRep salesRep;


    public long getVanID() {
        return vanID;
    }

    public void setVanID(long vanID) {
        this.vanID = vanID;
    }

    public String getVanModel() {
        return vanModel;
    }

    public void setVanModel(String vanModel) {
        this.vanModel = vanModel;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}
