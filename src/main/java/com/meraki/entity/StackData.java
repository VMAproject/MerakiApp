package com.meraki.entity;//package com.authorization.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
///**
// * Created by Verlamov on 07.03.17.
// */
//@Data
//@Entity
//@Table(name = "stack_data")
//public class StackData {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "stack_id")
//    private int stackId;
//
//    @Column(name = "clientMac")
//    private String clientMac;
//
//    @Column(name = "manufacturer")
//    private String manufacturer;
//
//    @Column(name = "seenEpoch")
//    private String seenEpoch;
//
//    @Column(name = "seenTime")
//    private String seenTime;
//
//    @Column(name = "rssi")
//    private long rssi;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "router_id", nullable = false)
//    private RouterService router;
//}
