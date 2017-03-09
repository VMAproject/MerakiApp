package com.meraki.model;//package com.authorization.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * Created by Verlamov on 07.03.17.
// */
//@Data
//@Entity
//@Table(name = "router")
//public class Router {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "router_id")
//    private int routerId;
//
//    @Column(name = "serial_num")
//    private String serialNum;
//
//    @Column(name = "router_name")
//    private String routerName;
//
//    @OneToOne(optional = false, mappedBy = "router")
//    private Event event;
//
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "router")
//    private Set<StackData> stackDataSet;
//
//
//}
