package com.meraki.statistics.service.impls;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import com.meraki.entity.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class StatisticServiceImpl2 {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Observation> getAllUniqueClientsByEventId(long id) {
        List<Observation> resultList = new ArrayList<>();
        Event event = getEventById(id);
        Long[] routersId = getRoutersId(getRoutersByEventId(id));

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> loadedList = (List<Observation>) session
                .createSQLQuery("SELECT * FROM Observation WHERE rssi >= 15 AND (seenTime BETWEEN (:dateFrom) AND (:dateTo)) AND router_id IN (:routersId) GROUP BY clientMac ORDER BY seenTime ASC;")
                .addEntity(Observation.class)
                .setParameterList("routersId", routersId)
                .setParameter("dateFrom", event.getDateFrom())
                .setParameter("dateTo", event.getDateTo())
                .list();
        transaction.commit();
        session.close();

        resultList.addAll(loadedList);

        return resultList;
    }

    @SuppressWarnings("unchecked")
    public List<Observation> compareEventToStore(long eventId, long storeId) {
        List<Observation> resultList = new ArrayList<>();
        Event event = getEventById(eventId);
        Long[] eventRoutersId = getRoutersId(getRoutersByEventId(eventId));
        Long[] storeRoutersId = getRoutersId(getRoutersByStoreId(storeId));

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> loadedList = session
                .createSQLQuery("SELECT * FROM Observation WHERE\n" +
                        "  clientMac IN\n" +
                        "  (SELECT clientMac FROM observation WHERE seenTime BETWEEN (:dateFrom) AND (:dateTo) AND router_id IN (:eventRoutersId) GROUP BY clientMac)\n" +
                        "  AND clientMac IN\n" +
                        "      (SELECT clientMac FROM observation WHERE seenTime >= (:dateFrom) AND router_id IN (:storeRoutersId) GROUP BY clientMac)\n" +
                        "  AND rssi >= 15\n" +
                        "GROUP BY clientMac ORDER BY seenTime ASC")
                .addEntity(Observation.class)
                .setParameterList("eventRoutersId", eventRoutersId)
                .setParameterList("storeRoutersId", storeRoutersId)
                .setParameter("dateFrom", event.getDateFrom())
                .setParameter("dateTo", event.getDateTo())
                .list();
        transaction.commit();
        session.close();

        resultList.addAll(loadedList);

        return resultList;
    }

    private Long[] getRoutersId(List<Router> routers) {
        Long[] resultArray = new Long[routers.size()];
        int i = 0;
        for (Router router : routers) {
            resultArray[i] = router.getId();
            i++;
        }

        return resultArray;
    }

    @SuppressWarnings("unchecked")
    private List<Router> getRoutersByEventId(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Router> routers;
        routers = (List<Router>) session.createQuery("from Router where event_id = (:id)")
                .setParameter("id", id)
                .list();
        transaction.commit();
        session.close();


        return routers;
    }

    @SuppressWarnings("unchecked")
    private List<Router> getRoutersByStoreId(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Router> routers;
        routers = (List<Router>) session.createQuery("from Router where store_id = (:id)")
                .setParameter("id", id)
                .list();
        transaction.commit();
        session.close();

        return routers;
    }

    private Event getEventById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event;
        event = (Event) session.createQuery("from Event where event_id = (:id)").setParameter("id", id).uniqueResult();
        transaction.commit();
        session.close();

        return event;
    }

    private Store getStoreById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Store store = (Store) session.createQuery("from Store where store_id = (:id)").setParameter("id", id).uniqueResult();
        transaction.commit();
        session.close();

        return store;
    }
}
