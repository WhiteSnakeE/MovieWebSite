package com.vladkharchenko.coursework.spring.mycoursework.service;

import com.vladkharchenko.coursework.spring.mycoursework.dao.MoviesRepository;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Customer;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesImpl implements MoviesService {
    @Autowired
     private MoviesRepository moviesRepository;


    @Override
    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public void saveMovie(Customer customer) {

    }

    @Override
    public Movie getMovie(int id) {
        Movie movie = null;
        Optional<Movie> optional = moviesRepository.findById(id);
        if(optional.isPresent()){
            movie = optional.get();
        }
        return movie;
    }

    @Override
    public void deleteMovie(int id) {

    }
}
