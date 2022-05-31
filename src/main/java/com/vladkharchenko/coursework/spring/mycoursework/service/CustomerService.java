package com.vladkharchenko.coursework.spring.mycoursework.service;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);






}
