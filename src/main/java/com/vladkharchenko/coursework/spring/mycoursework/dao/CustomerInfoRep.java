package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Customerinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRep extends JpaRepository<Customerinfo,Integer> {


}
