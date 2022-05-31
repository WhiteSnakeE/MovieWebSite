package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRep extends JpaRepository<Company,Integer> {
}
