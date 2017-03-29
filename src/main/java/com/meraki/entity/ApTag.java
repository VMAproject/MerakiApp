package com.meraki.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Verlamov on 21.03.17.
 */
@Entity
@Table(name = "apTag")
public class ApTag implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "apTags")
    private String apTags;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "router_id")
    private Router router;


}
