package com.meraki.service.impl;

import com.meraki.dao.RouterDao;
import com.meraki.entity.Router;
import com.meraki.service.RouterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */

@Service("routerService")
@Transactional
public class RouterServiceImpl implements RouterService {

    private RouterDao routerDao;

    @Override
    public Router findById(int id) {
        return routerDao.findById(id);
    }

    @Override
    public Router findByType(String type) {
        return routerDao.findByType(type);
    }

    @Override
    public List<Router> findAll() {
        return routerDao.findAll();
    }
}
