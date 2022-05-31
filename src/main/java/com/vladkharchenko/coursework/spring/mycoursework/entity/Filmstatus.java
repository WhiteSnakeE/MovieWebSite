package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "filmstatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Filmstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_issuing")
    private int id_issuing;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "id_issuing")
    private Issuingfilm issuingFilms;

}
