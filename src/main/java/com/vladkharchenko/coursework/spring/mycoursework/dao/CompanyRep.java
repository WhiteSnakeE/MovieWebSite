package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Company;
import com.vladkharchenko.coursework.spring.mycoursework.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRep extends JpaRepository<Company,Integer> {

    Company findByCompanyName(String name);
}
