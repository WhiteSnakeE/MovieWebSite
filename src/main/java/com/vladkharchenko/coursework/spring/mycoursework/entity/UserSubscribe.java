package com.vladkharchenko.coursework.spring.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "usersubcribe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSubscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id_subscribe;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private  Date end;

    @OneToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
