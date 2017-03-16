package com.meraki.dao;

import com.meraki.entity.Event;
import com.meraki.entity.Router;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface RouterDao {

    void addRouter(Router router);

    void updateRouter(Router router);

    void removeRouter(int id);

    Router getRouterById(int id);

    List<Router> getRouterList();


}
