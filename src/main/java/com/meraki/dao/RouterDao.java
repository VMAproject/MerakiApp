package com.meraki.dao;

import com.meraki.entity.Router;

import java.util.List;


public interface RouterDao {

    long createRouter(Router router);

    Router updateRouter(Router router);

    void deleteRouter(long id);

    List<Router> getAllRouters();

    Router getRouter(long id);

}
