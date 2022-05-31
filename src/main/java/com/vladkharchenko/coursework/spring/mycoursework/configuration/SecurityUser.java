package com.vladkharchenko.coursework.spring.mycoursework.configuration;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {


    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorityList;

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorityList) {
        this.username = username;
        this.password = password;
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static UserDetails fromUser(Customer customer){
        return new User(
                customer.getLogin(), customer.getPassword(),
                customer.getRole().getAuthorities()
        );
    }
}
