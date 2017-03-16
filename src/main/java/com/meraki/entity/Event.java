package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", updatable = false, insertable = false)
    private List<Router> routerList;


//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = true, nullable = true)
//    private RouterService router;


}
