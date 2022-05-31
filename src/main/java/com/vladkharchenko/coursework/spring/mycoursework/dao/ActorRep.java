package com.vladkharchenko.coursework.spring.mycoursework.dao;

import com.vladkharchenko.coursework.spring.mycoursework.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRep extends JpaRepository<Actor,Integer> {
}
