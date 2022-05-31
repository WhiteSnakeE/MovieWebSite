package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRep extends JpaRepository<Author,Integer> {
}
