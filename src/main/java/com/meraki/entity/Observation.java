package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Verlamov on 21.03.17.
 */
@Data
@Entity
@Table(name = "observation")
public class Observation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "clientMac")
    private String clientMac;

    @Column(name = "ipv4")
    private String ipv4;

    @Column(name = "ipv6")
    private String ipv6;

    @Column(name = "ssid")
    private String ssid;

    @Column(name = "os")
    private String os;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "rssi")
    private int rssi;

    @Column(name = "seenEpoch")
    private int seenEpoch;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "seenTime")
    private Date seenTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "router_id")
    private Router router;


}
