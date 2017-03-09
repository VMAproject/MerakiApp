package com.meraki.model;//package com.authorization.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//
//
//@Data
//@Entity
//@Table(name = "event")
//public class Event {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "event_id")
//    private int eventId;
//
//    @Column(name = "location")
//    private String location;
//
//    @Column(name = "date_to")
//    private Date dateTo;
//
//    @Column(name = "date_from")
//    private Date dateFrom;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = true, nullable = false)
//    private Router router;
//
//
//}
