package com.meraki.service.impl;

import com.meraki.dao.RouterDao;
import com.meraki.entity.Router;
import com.meraki.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */

@Service
@Transactional
public class RouterServiceImpl implements RouterService {

    @Autowired
    private RouterDao routerDao;

    @Autowired
    public void setRouterDao(RouterDao routerDao) {
        this.routerDao = routerDao;
    }

    @Override
    public void addRouter(Router router) {
        routerDao.addRouter(router);
    }

    @Override
    public void updateRouter(Router router) {
        routerDao.updateRouter(router);
    }

    @Override
    public void removeRouter(int id) {
        routerDao.removeRouter(id);
    }

    @Override
    public Router getRouterById(int id) {
        return routerDao.getRouterById(id);
    }

    @Override
    public List<Router> getRouterList() {
        return routerDao.getRouterList();
    }
}
