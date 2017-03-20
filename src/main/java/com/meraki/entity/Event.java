package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;


@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = -7988799579036225132L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private long id;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
    private Set<Router> routers;

    public Event() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.location, that.location) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.routers, that.routers) &&
                Objects.equals(this.serialVersionUID, that.serialVersionUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, name, routers, serialVersionUID);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id = " + id)
                .add("location = " + location)
                .add("name = " + name)
                .add("routers = " + routers)
                .add("serialVersionUID = " + serialVersionUID)
                .toString();
    }


//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = false, nullable = true)
//    private Router router;


}
