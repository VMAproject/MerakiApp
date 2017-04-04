package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "seenTime")
    private Date seenTime;

    @ManyToOne()
    @JoinColumn(name = "router_id")
    private Router router;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Observation that = (Observation) o;

        return Objects.equals(this.clientMac, that.clientMac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientMac);
    }
}
