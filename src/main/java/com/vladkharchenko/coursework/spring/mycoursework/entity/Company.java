package com.vladkharchenko.coursework.spring.mycoursework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private int id_company;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "year_of_foundation")
    private int yearOfFoundation ;

    @Column(name = "country")
    private String country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name =  "id_movies" )
    private List<Movie> movies;
}
