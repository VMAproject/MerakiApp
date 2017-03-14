package com.meraki.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "router")
public class Router implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial_num")
    private String serialNum;

    @Column(name = "router_name")
    private String routerName;
//
//    @OneToOne(optional = false, mappedBy = "router")
//    private Event event;

//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "router")
//    private Set<StackData> stackDataSet;


}
