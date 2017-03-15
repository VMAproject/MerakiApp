package com.meraki.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "router")
public class Router implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private Long id;

    @Column(name = "serial_num")
    private String serialNum;

    @Column(name = "router_name")
    private String routerName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "router")
    private Set<Event> events;

//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "router")
//    private Set<StackData> stackDataSet;


}
