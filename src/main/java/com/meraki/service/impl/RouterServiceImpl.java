package com.meraki.service.impl;

import com.meraki.dao.interfaces.RouterDao;
import com.meraki.entity.Router;
import com.meraki.service.interfaces.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RouterServiceImpl implements RouterService {

    @Autowired
    private RouterDao routerDao;

    @Override
    public long createRouter(Router router) {
        return routerDao.createRouter(router);
    }

    @Override
    public Router updateRouter(Router router) {
        return routerDao.updateRouter(router);
    }

    @Override
    public void deleteRouter(long id) {
        routerDao.deleteRouter(id);
    }

    @Override
    public List<Router> getAllRouters() {
        return routerDao.getAllRouters();
    }

    @Override
    public Router getRouter(long id) {
        return routerDao.getRouter(id);
    }
}
