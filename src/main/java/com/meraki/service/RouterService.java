package com.meraki.service;

import com.meraki.entity.Router;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface RouterService {

    void addRouter(Router router);

    void updateRouter(Router router);

    void removeRouter(int id);

    Router getRouterById(int id);

    List<Router> getRouterList();

//    Router getRoutreListById(int id);

}
