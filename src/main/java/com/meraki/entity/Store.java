//package com.meraki.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by Verlamov on 23.03.17.
// */
//@Entity
//@Table(name = "store")
//public class Store implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "store_id")
//    private long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "location")
//    private String location;
//
//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Router> routers = new HashSet<>();
//}
