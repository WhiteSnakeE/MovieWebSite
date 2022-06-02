package com.vladkharchenko.coursework.spring.mycoursework.controller;

import com.vladkharchenko.coursework.spring.mycoursework.dao.AuthorRep;
import com.vladkharchenko.coursework.spring.mycoursework.dao.CustomerRepository;
import com.vladkharchenko.coursework.spring.mycoursework.dao.MoviesRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.*;
import com.vladkharchenko.coursework.spring.mycoursework.service.CustomerService;
import com.vladkharchenko.coursework.spring.mycoursework.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private AuthorRep authorRep;
    @Autowired
    private MoviesService moviesService;
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
    public String editInfo(Principal principal, Model customerInfoModel,Model customerModel){
        Customer customer = customerRepository.findByLogin(principal.getName());
        Customerinfo customerinfo = customer.getCustomerinfo();
        customerInfoModel.addAttribute("customerInfo1",customerinfo);
        customerModel.addAttribute("customer1",customer);
        return "edit-info";
    }
    @PostMapping("/information/new")
    public String setInfo(Customerinfo customerinfo,Principal principal,@ModelAttribute Customer customer1){
        Customer customer = customerRepository.findByLogin(principal.getName());
        customer.getCustomerinfo().setName(customerinfo.getName());
        customer.getCustomerinfo().setSurname(customerinfo.getSurname());
        customer.getCustomerinfo().setAge(customerinfo.getAge());
        customer.getCustomerinfo().setMobilePhone(customerinfo.getMobilePhone());
        customerinfo.setCustomer(customer);
        customer.setLogin(customer1.getLogin());
        customer.setEmail(customer1.getEmail());
        customerRepository.save(customer);
        return "login";
    }
    @GetMapping("/movies")
    public String showAllMovies(Model model){
        List<Movie> movies = moviesRepository.getAllMoviesBy();
        System.out.println(movies);
        model.addAttribute("Movies",movies);
        return "movies";
    }
    @GetMapping("/movies/{id}")
    public String showMovie(@PathVariable int id, Model model){
        Movie movie = moviesService.getMovie(id);
//        Author author = authorRep.getById(movie.getAuthor().getId());
        model.addAttribute("Movie",movie);
        model.addAttribute("MovieCompany",movie.getCompany().getCompanyName());
        model.addAttribute("MovieActors",movie.getActors());
        model.addAttribute("MovieAuthor",movie.getAuthor());
        return "movies-watch";
    }
}
