package com.meraki.dao;

import com.meraki.entity.Event;
import com.meraki.entity.Router;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface RouterDao {

    long createRouter(Router router);

    Router updateRouter(Router router);

    void deleteRouter(long id);

    List<Router> getAllRouters();

    Router getRouter(long id);

}
