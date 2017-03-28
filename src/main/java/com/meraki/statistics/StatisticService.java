package com.meraki.statistics;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Observation> getAllUniqueObservationsByEventId(long id) {
        List<Observation> resultSet = new ArrayList<>();

        List<Router> loadedRouters = getRoutersByEventId(id);

        List<Observation> tempList;
        for (Router router : loadedRouters) {
            tempList = getObservationsByRouterId(router.getId());
            resultSet.addAll(tempList);
        }

        return resultSet;
    }

    private List<Router> getRoutersByEventId(long id) {
        List<Router> resultList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Router> loadedList = session.createQuery("from Router r where r.event.id = " + id).list();
        transaction.commit();
        session.flush();
        session.close();

        resultList.addAll(loadedList);

        return resultList;
    }

    private List<Observation> getObservationsByRouterId(long id) {
        List<Observation> resultList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> loadedList = session.createQuery("from Observation o where o.router.id = " + id).list();
        transaction.commit();
        session.flush();
        session.close();

        resultList.addAll(loadedList);

        return resultList;
    }

}
