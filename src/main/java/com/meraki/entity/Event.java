package com.meraki.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


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

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "date_from")
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "date_to")
    private Date dateTo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event",
            cascade = CascadeType.ALL)
    private Set<Router> routers = new HashSet<>();

    public Event() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        return Objects.equals(this.dateFrom, that.dateFrom) &&
                Objects.equals(this.dateTo, that.dateTo) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.location, that.location) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.routers, that.routers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateFrom, dateTo, id, location, name, routers);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("dateFrom = " + dateFrom)
                .add("dateTo = " + dateTo)
                .add("id = " + id)
                .add("location = " + location)
                .add("name = " + name)
                .add("routers = " + routers)
                .toString();
    }

    public void setRouters() {
    }


//    @OneToOne(optional = false)
//    @JoinColumn(name = "router_id", unique = false, nullable = true)
//    private Router router;


}
