package com.meraki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Data
@Entity
@Table(name = "router")
public class Router implements Serializable {

    private static final long serialVersionUID = -7988799579036225139L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private long id;

    @Column(name = "apMac")
    private String apMac;

    @Column(name = "router_name")
    private String routerName;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", nullable = true,updatable = false, insertable = false)
    private Event event;

    public Router() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Router that = (Router) o;

        return Objects.equals(this.apMac, that.apMac) &&
                Objects.equals(this.event, that.event) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.routerName, that.routerName) &&
                Objects.equals(this.serialVersionUID, that.serialVersionUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apMac, event, id, routerName, serialVersionUID);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("apMac = " + apMac)
                .add("event = " + event)
                .add("id = " + id)
                .add("routerName = " + routerName)
                .add("serialVersionUID = " + serialVersionUID)
                .toString();
    }


//    @OneToOne(optional = false, mappedBy = "router")
//    private Event event;


}
