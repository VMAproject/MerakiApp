package com.meraki.dao.impls;

import com.meraki.dao.interfaces.RouterDao;
import com.meraki.entity.Router;
import com.meraki.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouterDaoImpl implements RouterDao {

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createRouter(Router router) {
        return (Long) hibernateUtil.create(router);
    }

    @Override
    public Router updateRouter(Router router) {
        return hibernateUtil.update(router);
    }

    @Override
    public void deleteRouter(long id) {
        Router router = new Router();
        router.setId(id);
        hibernateUtil.delete(router);
    }

    @Override
    public List<Router> getAllRouters() {
        return hibernateUtil.fetchAll(Router.class);
    }

    @Override
    public Router getRouter(long id) {
        return hibernateUtil.fetchById(id, Router.class);
    }
}
