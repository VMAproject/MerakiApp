package com.meraki.statistics.impls;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import com.meraki.statistics.dao.interfaces.StatisticDao;
import com.meraki.statistics.interfaces.StatisticService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatisticServiceImpl implements StatisticService {


    @Autowired
    private StatisticDao statisticDao;

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Set<Observation> getAllUniqueObservationsByEventId(long id) {
        Set<Observation> resultSet = new HashSet<>();

        List<Observation> listWithoutUniqueness = getAllObservationsByEventId(id);
        List<Observation> listWithConsideringRssi = new ArrayList<>();
        for (Observation obsv : listWithoutUniqueness) {
            if (obsv.getRssi() >= 15) {
                listWithConsideringRssi.add(obsv);
            }
        }
        resultSet.addAll(listWithConsideringRssi);

        return resultSet;
    }

    @Transactional
    public List<Observation> getAllObservationsByEventId(long id) {
        List<Observation> resultSet = new ArrayList<>();

        List<Router> loadedRouters = getRoutersByEventId(id);

        List<Observation> tempList;
        for (Router router : loadedRouters) {
            tempList = getObservationsByRouterId(router.getId());
            resultSet.addAll(tempList);
        }

        return resultSet;
    }

    @Transactional
    public List<Router> getRoutersByEventId(long id) {
//        List<Router> resultList = new ArrayList<>();
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<Router> loadedList = session.createQuery("from Router r where r.event.id = " + id).list();
//        transaction.commit();
//        session.flush();
//        session.close();
//
//        resultList.addAll(loadedList);

        return statisticDao.getRoutersByEventId(id);
    }

    @Transactional
    public List<Observation> getObservationsByRouterId(long id) {
//        List<Observation> resultList = new ArrayList<>();
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        List<Observation> loadedList = session.createQuery("from Observation o where o.router.id = " + id).list();
//        transaction.commit();
//        session.flush();
//        session.close();
//
//        resultList.addAll(loadedList);

        return statisticDao.getObservationsByRouterId(id);
    }

}
