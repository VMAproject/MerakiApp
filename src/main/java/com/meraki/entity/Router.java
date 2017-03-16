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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "router_id")
    private Integer routerId;
//
//    @Column(name = "serial_num")
//    private String serialNum;
//
//    @Column(name = "router_name")
//    private String routerName;

    @Column(name = "type", length = 15, unique = true, nullable = true)
    private String type = RouterType.PORTABLE.getRouterType();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Router that = (Router) o;

        return Objects.equals(this.routerId, that.routerId) &&
                Objects.equals(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routerId, type);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("routerId = " + routerId)
                .add("type = " + type)
                .toString();
    }
}
