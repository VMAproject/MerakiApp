package com.meraki.dao.impl;

import com.meraki.dao.RouterDao;
import com.meraki.entity.Router;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */

@Repository
public class RouterDaoImpl implements RouterDao {

    private static final Logger logger = LoggerFactory.getLogger(RouterDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRouter(Router router) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(router);
        logger.info("Router saved successfully, Router Details=" + router);
    }

    @Override
    public void updateRouter(Router router) {
        Session session = sessionFactory.getCurrentSession();
        session.update(router);
        logger.info("Router update successfully, Router Details=" + router);
    }

    @Override
    public void removeRouter(int id) {
        Session session = sessionFactory.getCurrentSession();
        Router router = (Router) session.load(Router.class, new Integer(id));
        if (null != router) {
            session.delete(router);
        }
        logger.info("Router delete successfully, Router Details=" + router);
    }

    @Override
    public Router getRouterById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Router router = (Router) session.load(Router.class, new Integer(id));
        logger.info("Router loaded successfully,Router details=" + router);
        return router;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Router> getRouterList() {
        Session session = sessionFactory.getCurrentSession();
        List<Router> routerList = session.createQuery("from Router").list();
        for (Router router : routerList) {
            logger.info("Router list::" + router);
        }
        return routerList;
    }
}
