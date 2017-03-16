package com.meraki.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;

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

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Event_Router",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "router_id")})
    private Set<Router> routers = new HashSet<>();


//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = true, nullable = true)
//    private RouterService router;


}
