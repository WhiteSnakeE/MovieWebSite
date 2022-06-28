package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRep extends JpaRepository<Genre,Integer> {

    Genre findByName(String name);
}
