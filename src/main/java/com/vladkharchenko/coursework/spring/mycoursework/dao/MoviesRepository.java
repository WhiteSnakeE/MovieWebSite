package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movie,Integer> {
}
