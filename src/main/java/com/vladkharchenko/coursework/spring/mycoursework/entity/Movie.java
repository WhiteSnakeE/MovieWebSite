package com.vladkharchenko.coursework.spring.mycoursework.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movies")
    private int id_movies;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "release_data")
    private int releaseData;

    @Column(name = "movies_price")
    private int movies_price;

    @Column(name = "review")
    private float review;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "id_issuing" )
    private List<Issuingfilm> issuingfilmsList;

//
//    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(name ="movies_has_genre"
//            ,joinColumns = @JoinColumn(name = "id_movies")
//            ,inverseJoinColumns = @JoinColumn(name = "id_genre"))
//
//    private List<Genre> genres;
//
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name ="movies_has_actors"
            ,joinColumns = @JoinColumn(name = "id_movies")
            ,inverseJoinColumns = @JoinColumn(name = "id_actors"))
    private List<Actor> actors;

//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name =  "id_issuing" )
//    private List<IssuingFilms> issuingFilms;
//
//    public void addGenreToMovie(Genre genre){
//        if(genre==null){
//            genres = new ArrayList<>();
//        }
//        genres.add(genre);
//    }
//
//    public void addActorToMovie(Actors actor){
//        if(actor==null){
//            actors = new ArrayList<>();
//        }
//        actors.add(actor);
//    }
}
