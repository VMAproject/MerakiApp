package com.meraki.entity;

/**
 * Created by Verlamov on 15.03.17.
 */


public enum RouterType {

    PORTABLE("PORTABLE"),
    STATIONARY("STATIONARY");

    String routerType;

    RouterType(String routerType) {
        this.routerType = routerType;
    }

    public String getRouterType() {
        return routerType;
    }
}
