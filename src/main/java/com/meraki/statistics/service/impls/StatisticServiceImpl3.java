package com.meraki.statistics.service.impls;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StatisticServiceImpl3 {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Observation> getUniqueStoreVisitorsByEventId(long id, Long[] storesId) {
        Event loadedEvent = getEventById(id);

        List<Observation> uniqueEventVisitors = getUniqueEventVisitors(loadedEvent);
        List<Observation> uniqueStoreVisitors = getUniqueStoreVisitors(loadedEvent.getDateFrom(), storesId);

        List<Observation> resultList = new ArrayList<>(uniqueStoreVisitors);
        resultList.retainAll(uniqueEventVisitors);

        resultList.sort(Comparator.comparing(Observation::getSeenTime));

        return resultList;
    }

    private Event getEventById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event = (Event) session
                .createQuery("from Event e where e.id = (:id)")
                .setParameter("id", id)
                .uniqueResult();
        transaction.commit();
        session.close();

        return event;
    }

    @SuppressWarnings("unchecked")
    private List<Observation> getUniqueEventVisitors(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> uniqueEventVisitors = session
                .getNamedQuery("getUniqueEventVisitors")
                .setParameter("id", event.getId())
                .setParameter("dateFrom", event.getDateFrom())
                .setParameter("dateTo", event.getDateTo())
                .list();
        transaction.commit();
        session.close();

        return uniqueEventVisitors;
    }

    @SuppressWarnings("unchecked")
    private List<Observation> getUniqueStoreVisitors(Date dateFrom, Long[] storesId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> uniqueStoreVisitors = session
                .getNamedQuery("getUniqueStoreVisitors")
                .setParameterList("id", storesId)
                .setParameter("dateFrom", dateFrom)
                .list();
        transaction.commit();
        session.close();

        return uniqueStoreVisitors;
    }

}
