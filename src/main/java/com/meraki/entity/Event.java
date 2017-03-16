package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", updatable = false, insertable = false)
    private List<Router> routers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.location, that.location) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.routers, that.routers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, name, routers);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id = " + id)
                .add("location = " + location)
                .add("name = " + name)
                .add("routers = " + routers)
                .toString();
    }


//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = true, nullable = true)
//    private RouterService router;


}
