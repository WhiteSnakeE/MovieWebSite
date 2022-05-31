package com.vladkharchenko.coursework.spring.mycoursework.controller;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vladkharchenko.coursework.spring.mycoursework.service.CustomerService;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private CustomerService customerService;



    @GetMapping("/customers")
    private List<Customer> showAllCustomers(){
       List<Customer> customerList = customerService.getAllCustomers();
       return customerList;
    }


    @GetMapping("customers/{id}")
    private Customer showCustomer(@PathVariable int id){
      Customer customer = customerService.getCustomer(id);
      return customer;

    }
    @PostMapping("/customers")
    private Customer newCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }
    @PutMapping("/customers")
    private Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }
    @DeleteMapping("/customers/{id}")
    private String deleteCustomer(@PathVariable int id){
        Customer customer = customerService.getCustomer(id);
         customerService.deleteCustomer(id);
         return "Employee with login = " + id + " was deleted";

    }
//    @GetMapping("/customers/info/{id}")
//    private CustomerInfo getCustomerInfo(@PathVariable String id){
//        Customer customer = customerService.getCustomer(id);
//        CustomerInfo customerInfo = customer.getCustomerinfo();
//        return customerInfo;
//    }
}
