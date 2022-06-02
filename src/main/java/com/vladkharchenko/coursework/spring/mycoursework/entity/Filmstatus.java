package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "filmstatus")
@Getter
@Setter
@NoArgsConstructor

public class Filmstatus {
    @Id
    @Column(name = "id_issuing")
    private int id_issuing;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "id_issuing")
    private Issuingfilm issuingFilms;
    public Filmstatus(Status status, Issuingfilm issuingFilms) {
        this.status = status;
        this.issuingFilms = issuingFilms;
    }
}
