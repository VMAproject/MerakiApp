package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "store")
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "store")
    private Set<Router> routers = new HashSet<>();
}
