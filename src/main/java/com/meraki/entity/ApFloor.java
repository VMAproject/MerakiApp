package com.meraki.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "apFloor")
public class ApFloor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "apFloors")
    private String apFloors;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "router_id")
    private Router router;
}
