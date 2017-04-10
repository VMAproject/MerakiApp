package com.meraki.statistics.service.impls;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatisticServiceImpl3 {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Observation> compareEventToStore(long eventId, long storeId) {
        Event event = getEventById(eventId);
        long dateFrom = event.getDateFrom().getTime();
        long dateTo = event.getDateTo().getTime();

        Long[] eventRoutersId = getRoutersId(getRoutersByEventId(eventId));
        Long[] storeRoutersId = getRoutersId(getRoutersByStoreId(storeId));

        List<Observation> uniqueClientsByEventRoutersId = getUniqueClientsByRoutersId(eventRoutersId);
        List<Observation> uniqueClientsByStoreRoutersId = getUniqueClientsByRoutersId(storeRoutersId);

        List<Observation> uniqueClientsByEventRoutersIdWithDate = new ArrayList<>();
        List<Observation> uniqueClientsByStoreRoutersIdWithDate = new ArrayList<>();

        for (Observation obsv : uniqueClientsByEventRoutersId) {
            long seenTime = obsv.getSeenTime().getTime();
            if (seenTime >= dateFrom && seenTime <= dateTo) {
                uniqueClientsByEventRoutersIdWithDate.add(obsv);
            }
        }
        for (Observation obsv : uniqueClientsByStoreRoutersId) {
            long seenTime = obsv.getSeenTime().getTime();
            if (seenTime >= dateFrom) {
                uniqueClientsByStoreRoutersIdWithDate.add(obsv);
            }
        }

        List<Observation> resultList = new ArrayList<>(uniqueClientsByStoreRoutersIdWithDate);
        resultList.retainAll(uniqueClientsByEventRoutersIdWithDate);


        Collections.sort(resultList, Comparator.comparing(Observation::getSeenTime));

        return resultList;
    }


    private Event getEventById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event = (Event) session.createQuery("from Event where event_id = (:id)")
                .setParameter("id", id)
                .uniqueResult();
        transaction.commit();
        session.close();

        return event;
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
        List<Router> routers = (List<Router>) session.createQuery("from Router where event_id = (:id)")
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
        List<Router> routers = (List<Router>) session.createQuery("from Router where store_id = (:id)")
                .setParameter("id", id)
                .list();
        transaction.commit();
        session.close();

        return routers;
    }

    @SuppressWarnings("unchecked")
    private List<Observation> getUniqueClientsByRoutersId(Long[] routersId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Observation> uniqueClients = (List<Observation>) session
                .createSQLQuery("SELECT * FROM Observation WHERE router_id IN (:routersId) AND rssi >= 15 GROUP BY clientMac")
                .addEntity(Observation.class)
                .setParameterList("routersId", routersId)
                .list();
        transaction.commit();
        session.close();

        return uniqueClients;
    }

}
