package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "router")
public class Router implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private Integer routerId;

    @Column(name = "serial_num")
    private String serialNum;

    @Column(name = "router_name")
    private String routerName;

    @Column(name = "event_id")
    private Integer eventId;


}
