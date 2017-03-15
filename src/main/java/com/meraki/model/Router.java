package com.meraki.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "router")
public class Router implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private Long id;

    @Column(name = "serial_num")
    private String serialNum;

    @Column(name = "router_name")
    private String routerName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "router")
    private Set<Event> events;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Router that = (Router) o;

        return Objects.equals(this.events, that.events) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.routerName, that.routerName) &&
                Objects.equals(this.serialNum, that.serialNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(events, id, routerName, serialNum);
    }
}
