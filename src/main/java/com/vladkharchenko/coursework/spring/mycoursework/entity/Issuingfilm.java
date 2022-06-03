package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "issuingfilms")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Issuingfilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_issuing")
    private int id_issuing;

    @Column(name = "issuing_data")
    private LocalDate issuingData;

    @Column(name = "return_data")
    private LocalDate returnData;

    @ManyToOne
    @JoinColumn(name = "id_movies")
    @JsonBackReference
    private Movie movie;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "issuingFilms",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Filmstatus filmstatus;


}
