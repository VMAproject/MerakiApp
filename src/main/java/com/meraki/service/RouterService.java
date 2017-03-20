package com.meraki.service;

import com.meraki.entity.Router;
import java.util.List;


public interface RouterService {

    long createRouter(Router router);

    Router updateRouter(Router router);

    void deleteRouter(long id);

    List<Router> getAllRouters();

    Router getRouter(long id);

}
