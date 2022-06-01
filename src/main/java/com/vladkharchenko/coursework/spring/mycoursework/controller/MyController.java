package com.vladkharchenko.coursework.spring.mycoursework.controller;

import com.vladkharchenko.coursework.spring.mycoursework.dao.CustomerRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Customerinfo;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Role;
import com.vladkharchenko.coursework.spring.mycoursework.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
     private PasswordEncoder  passwordEncoder;

    @GetMapping({"/", ""})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model customerModel,Model customerInfoModel ){
        Customer customer = new Customer();
        Customerinfo customerinfo = new Customerinfo();
        customerModel.addAttribute("customer",customer);
        customerInfoModel.addAttribute("customerInfo",customerinfo);
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(Customer customer,Customerinfo customerinfo){
         customer.setPassword(passwordEncoder.encode(customer.getPassword()));
         customer.setRole(Role.USER);
         customer.setCustomerinfo(customerinfo);
         customerinfo.setCustomer(customer);
         customerRepository.save(customer);
        return "redirect:/login";
    }

    @GetMapping("/information")
    public String information(Principal principal ,Model model,Model customerModel){
        Customer customer = customerRepository.findByLogin(principal.getName());
        Customerinfo customerinfo = customer.getCustomerinfo();
        model.addAttribute("info",customerinfo);

        customerModel.addAttribute("infoCus",customer);
        return "information";
    }
    @GetMapping("/information/new")
    public String editInfo(Principal principal, Model model){
        Customer customer = customerRepository.findByLogin(principal.getName());
        Customerinfo customerinfo = customer.getCustomerinfo();
        model.addAttribute("customerInfo1",customerinfo);
        return "edit-info";
    }

    @PostMapping("/information/new")
    public String setInfo(Principal principal,Customerinfo customerinfo){
        Customer customer = customerRepository.findByLogin(principal.getName());
        customer.getCustomerinfo().setName(customerinfo.getName());
        customer.getCustomerinfo().setSurname(customerinfo.getSurname());
        customer.getCustomerinfo().setAge(customerinfo.getAge());
        customer.getCustomerinfo().setMobilePhone(customerinfo.getMobilePhone());
        customerinfo.setCustomer(customer);
        customerRepository.save(customer);
        return "index";
    }

}
