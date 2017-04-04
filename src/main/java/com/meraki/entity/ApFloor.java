package com.meraki.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Data
@Entity
@Table(name = "apFloor")
public class ApFloor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "apFloors")
    private String apFloors;

    @ManyToOne()
    @JoinColumn(name = "router_id")
    private Router router;

}
