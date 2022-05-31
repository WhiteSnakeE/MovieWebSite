package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

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
    private Date issuingData;

    @Column(name = "return_data")
    private Date returnData;

    @ManyToOne
    @JoinColumn(name = "id_movies")
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "issuingFilms",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Filmstatus filmstatus;




}
