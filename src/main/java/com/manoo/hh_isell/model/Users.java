package com.manoo.hh_isell.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity(name = "Users")
public class Users  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_ID")
    private int userID;

    @Column(name = "User_Name")
    @NotEmpty(message = "User name mustn't be empty")
    private String userName;

    @Column(name = "User_Password")
    @NotEmpty(message = "Password mustn't be empty")
    @Size(min = 5,message = "Password shouldn't be less than 5 characters ")
    @JsonIgnore
    private String password;

    @Column(name = "Is_Active")
    private int active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;



    public Users(){}

    public Users(Users users) {
        this.userName = users.getUserName();
        this.password=users.getPassword();
        this.active=users.getActive();
        this.roles=users.getRoles();
        this.userID=users.getUserID();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


}
