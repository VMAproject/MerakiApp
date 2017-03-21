package com.meraki.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {

//    private static final long serialVersionUID = -7988799579036225132L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "date_from")
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "date_to")
    private Date dateTo;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event",
//            cascade = CascadeType.ALL)
//    private Set<Router> routers = new HashSet<>();


    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Router> routers = new HashSet<>();

//    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Router> routers = new HashSet<>();

    public Event() {
    }

    public Event(String name, String location, Date dateFrom, Date dateTo, Set<Router> routers) {
        this.name = name;
        this.location = location;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.routers = routers;
    }
    //    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = false, nullable = true)
//    private Router router;


}
