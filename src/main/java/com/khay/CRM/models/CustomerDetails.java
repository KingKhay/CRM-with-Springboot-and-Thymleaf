package com.khay.CRM.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    CustomerDetails(Customer customer){
            this.username = customer.getUsername();
            this.password = customer.getPassword();
            SimpleGrantedAuthority user = new SimpleGrantedAuthority("ROLE_USER");
            List<GrantedAuthority> listOfAuthorities = new ArrayList<>();
            listOfAuthorities.add(user);
            this.authorities = listOfAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

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
