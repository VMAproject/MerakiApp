package com.meraki.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "router")
public class Router implements Serializable {

//    private static final long serialVersionUID = -7988799579036225139L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private Long id;

    @Column(name = "apMac")
    private String apMac;

    @Column(name = "router_name")
    private String routerName;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "router", fetch = FetchType.LAZY)
    private Set<Observation> observations = new HashSet<>();

    @OneToMany(mappedBy = "router", fetch = FetchType.LAZY)
    private Set<ApTag> apTags = new HashSet<>();

    @OneToMany(mappedBy = "router", fetch = FetchType.LAZY)
    private Set<ApFloor> apFloors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApMac() {
        return apMac;
    }

    public void setApMac(String apMac) {
        this.apMac = apMac;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<Observation> getObservations() {
        return observations;
    }

    public void setObservations(Set<Observation> observations) {
        this.observations = observations;
    }

    public Set<ApTag> getApTags() {
        return apTags;
    }

    public void setApTags(Set<ApTag> apTags) {
        this.apTags = apTags;
    }

    public Set<ApFloor> getApFloors() {
        return apFloors;
    }

    public void setApFloors(Set<ApFloor> apFloors) {
        this.apFloors = apFloors;
    }

}
