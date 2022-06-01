package com.vladkharchenko.coursework.spring.mycoursework.service;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Movie;

import java.util.List;

public interface MoviesService {
    public List<Movie> getAllMovies();

    public void saveMovie(Customer customer);

    public Movie getMovie(int id);

    public void deleteMovie(int id);
}
