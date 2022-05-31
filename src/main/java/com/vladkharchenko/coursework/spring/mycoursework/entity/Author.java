package com.vladkharchenko.coursework.spring.mycoursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_surname")
    private String authorSurName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name =  "id_movies" )
    private List<Movie> movies;

}
