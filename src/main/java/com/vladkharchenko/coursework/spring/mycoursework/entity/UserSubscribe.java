package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "usersubcribe")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserSubscribe {
    @Id
    @Column(name = "customer_id")
    private int id_subscribe;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "start")
    private LocalDate start;

    @Column(name = "end")
    private  LocalDate  end;

    public UserSubscribe(Status status,  LocalDate  start,  LocalDate  end, Customer customer) {
        this.status = status;
        this.start = start;
        this.end = end;
        this.customer = customer;
    }

    @OneToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
