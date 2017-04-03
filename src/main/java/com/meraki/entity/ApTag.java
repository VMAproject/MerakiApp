package com.meraki.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "apTag")
public class ApTag implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "apTags")
    private String apTags;

    @ManyToOne()
    @JoinColumn(name = "router_id")
    private Router router;


}
