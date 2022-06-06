package com.vladkharchenko.coursework.spring.mycoursework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
public class Genre {
    @Id
    @Column(name = "id_genre")
    private int id_genre;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name ="movies_has_genre"
            ,joinColumns = @JoinColumn(name = "id_genre")
            ,inverseJoinColumns = @JoinColumn(name = "id_movies"))
    private List<Movie> movies;

    public Genre(String name) {
        this.name = name;
    }
}
