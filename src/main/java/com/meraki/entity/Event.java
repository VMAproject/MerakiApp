package com.meraki.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {

//    private static final long serialVersionUID = -7988799579036225132L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "date_from")
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "date_to")
    private Date dateTo;

    @OneToMany(mappedBy = "event")
    private Set<Router> routers = new HashSet<>();

    public Event() {
    }

}
