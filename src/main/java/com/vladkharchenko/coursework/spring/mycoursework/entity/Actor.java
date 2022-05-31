package com.vladkharchenko.coursework.spring.mycoursework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actors")
    private int id_actors;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name ="movies_has_actors"
            ,joinColumns = @JoinColumn(name = "id_actors")
            ,inverseJoinColumns = @JoinColumn(name = "id_movies"))
    private List<Movie> movies;






}
