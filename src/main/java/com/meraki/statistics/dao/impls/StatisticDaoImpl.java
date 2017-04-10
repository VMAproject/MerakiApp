package com.meraki.statistics.dao.impls;

import com.meraki.dao.interfaces.EventDao;
import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.statistics.dao.interfaces.StatisticDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Repository
public class StatisticDaoImpl implements StatisticDao {

    private SessionFactory sessionFactory;
    private EventDao eventDao;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public List<Observation> getUniqueStoreVisitorsByEventId(Long id, Long[] storesId) {
        Event loadedEvent = eventDao.getEvent(id);

        List<Observation> uniqueEventVisitors = getUniqueEventVisitors(loadedEvent);
        List<Observation> uniqueStoreVisitors = getUniqueStoreVisitors(loadedEvent.getDateFrom(), storesId);

        List<Observation> resultList = new ArrayList<>(uniqueStoreVisitors);
        resultList.retainAll(uniqueEventVisitors);

        resultList.sort(Comparator.comparing(Observation::getSeenTime));

        return resultList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Observation> getUniqueEventVisitors(Event event) {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("getUniqueEventVisitors")
                .setParameter("id", event.getId())
                .setParameter("dateFrom", event.getDateFrom())
                .setParameter("dateTo", event.getDateTo())
                .list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Observation> getUniqueStoreVisitors(Date dateFrom, Long[] storesId) {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("getUniqueStoreVisitors")
                .setParameterList("id", storesId)
                .setParameter("dateFrom", dateFrom)
                .list();
    }

}
