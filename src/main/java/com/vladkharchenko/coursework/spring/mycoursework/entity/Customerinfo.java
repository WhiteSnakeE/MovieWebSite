package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customerinfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customerinfo {
    @Id
    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "mobilephone")
    private String mobilePhone;

    @OneToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;
}