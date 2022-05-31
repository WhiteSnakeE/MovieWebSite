package com.vladkharchenko.coursework.spring.mycoursework.configuration;

import com.vladkharchenko.coursework.spring.mycoursework.dao.CustomerRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl  implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByLogin(login).orElseThrow(()->
                new UsernameNotFoundException("User doesnt exist"));
        return SecurityUser.fromUser(customer);
    }
}
