package com.vladkharchenko.coursework.spring.mycoursework.controller;

import com.vladkharchenko.coursework.spring.mycoursework.dao.MoviesRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Customerinfo;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MyAdminController {

    @Autowired
    public MoviesRepository moviesRepository;

    @GetMapping("/index")
    public String registration() {

        return "admin-main-page";
    }

    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("NewMovie",movie);
        return "add-movie";
    }
    @PostMapping("/addMovie")
    public String createMovie(Movie movie) {
        moviesRepository.save(movie);
        return "admin-main-page";
    }
    @GetMapping("/allMovies")
    public String allMovies(Model model) {
        List<Movie> movie = moviesRepository.findAll();
        model.addAttribute("AllMovies",movie);
        return "admin-all-movies";
    }

    @GetMapping("/allMovies/{id}")
    public String updateMovie(@PathVariable int id, Model model) {
        Movie movie = moviesRepository.getById(id);
        model.addAttribute("MoviesInfo",movie);
        return "admin-movie-update";
    }
    @PostMapping("/allMovies/{id}")
    public String saveMovie(@PathVariable int id,@ModelAttribute Movie movie1) {
        Movie movie = moviesRepository.getById(id);
        System.out.println(movie.getId_movies());
        movie.setAuthor(movie1.getAuthor());
        movie.setMovie_name(movie1.getMovie_name());
        movie.setMovies_price(movie1.getMovies_price());
        movie.setCompany(movie1.getCompany());
        movie.setReleaseData(movie1.getReleaseData());
        movie.setReview(movie1.getReview());
        moviesRepository.save(movie);
        return "admin-main-page";
    }
    @PostMapping("/allMovies/{id}/delete")
    public String deleteMovie(@PathVariable int id) {
        Movie movie = moviesRepository.getById(id);
        moviesRepository.delete(movie);
        return "redirect:/admin/allMovies";
    }
}
