package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Issuingfilm;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByLogin(String login);


}
