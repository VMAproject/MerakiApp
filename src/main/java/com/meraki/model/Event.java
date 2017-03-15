package com.meraki.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

//    @Temporal(TemporalType.DATE)
//    @Column(name = "date_from")
//    private Date dateFrom;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "date_to")
//    private Date dateTo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "router_id", nullable = false)
    private Router router;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.location, that.location) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.router, that.router);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, name, router);
    }
}
