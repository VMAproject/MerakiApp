package com.meraki.statistics.dao.impls;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import com.meraki.statistics.dao.interfaces.StatisticDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Verlamov on 29.03.17.
 */
@Repository
public class StatisticDaoImpl implements StatisticDao {

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Router> getRoutersByEventId(long id) {
        List<Router> resultList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Router> loadedList = session.createQuery("from Router r where r.event.id = " + id).list();
        transaction.commit();
        session.flush();
        session.close();

        return resultList;
    }

    @Override
    public List<Observation> getObservationsByRouterId(long id) {

        List<Observation> resultList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> loadedList = session.createQuery("from Observation o where o.router.id = " + id).list();
        transaction.commit();
        session.flush();
        session.close();

        return resultList;
    }


}
