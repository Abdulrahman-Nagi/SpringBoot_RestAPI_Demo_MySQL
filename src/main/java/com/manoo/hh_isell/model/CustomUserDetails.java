package com.manoo.hh_isell.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;



public class CustomUserDetails  implements UserDetails, Serializable {



    private static final long serialVersionUID = 1L;
    private Users user;

    Set<GrantedAuthority> authorities=null;


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;

    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public String getPassword(){return user.getPassword();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
