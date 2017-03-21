package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "router")
public class Router implements Serializable {

//    private static final long serialVersionUID = -7988799579036225139L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private long id;

    @Column(name = "apMac")
    private String apMac;

    @Column(name = "router_name")
    private String routerName;


//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "event_id", nullable = true, updatable = true)
//    private Event event;


    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "router", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Observation> observations = new HashSet<>();

    @OneToMany(mappedBy = "router", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ApTag> apTags = new HashSet<>();

    @OneToMany(mappedBy = "router", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ApFloor> apFloors = new HashSet<>();


}
