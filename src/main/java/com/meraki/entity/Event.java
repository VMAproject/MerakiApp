package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

//    @Temporal(TemporalType.DATE)
//    @Column(name = "date_from")
//    private Date dateFrom;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "date_to")
//    private Date dateTo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "router_id", nullable = false)
    private Router router;


//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = true, nullable = true)
//    private Router router;


}
