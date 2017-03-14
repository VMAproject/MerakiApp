package com.meraki.service;

import com.meraki.dao.RouterDao;
import com.meraki.model.Event;
import com.meraki.model.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Verlamov on 14.03.17.
 */

@Service
@Transactional
public class RouterServiceImpl implements RouterService {


    @Autowired
    private RouterDao routerDao;

    @Override
    public List<Router> findAllRouter() {
        return routerDao.findAll();
    }

    @Override
    public Router findByRouterId(long id) {
        return routerDao.findOne(id);
    }
}
