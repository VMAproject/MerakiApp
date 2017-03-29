package com.meraki.dao.impls;

import com.meraki.dao.interfaces.RouterDao;
import com.meraki.entity.Router;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouterDaoImpl implements RouterDao {

    private static final Logger logger = LoggerFactory.getLogger(RouterDaoImpl.class);

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createRouter(Router router) {
        logger.info("*** Router Dao *** create Router => " + router);
        return (Long) hibernateUtil.create(router);
    }

    @Override
    public Router updateRouter(Router router) {
        logger.info("*** Router Dao *** update Router =>" + router);
        return hibernateUtil.update(router);
    }

    @Override
    public void deleteRouter(long id) {
        Router router = new Router();
        router.setId(id);
        logger.info("*** Router Dao *** delete Router for ID => " + id);
        hibernateUtil.delete(router);
    }

    @Override
    public List<Router> getAllRouters() {
        logger.info("*** Router Dao *** get All Routers =>" + Router.class);
        return hibernateUtil.fetchAll(Router.class);
    }

    @Override
    public Router getRouter(long id) {
        logger.info("*** Router Dao *** get Router for ID =>" + id + Router.class);
        return hibernateUtil.fetchById(id, Router.class);
    }
}
