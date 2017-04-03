package com.meraki.statistics.service.impls;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<Router> routersByEventId = getRoutersByEventId(id);
        Long[] routersId = getRoutersId(routersByEventId);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Observation> loadedList = (List<Observation>) session
                .createSQLQuery("SELECT * FROM Observation WHERE rssi >= 15 AND (seenTime BETWEEN (:dateFrom) AND (:dateTo)) AND router_id IN (:routersId) GROUP BY clientMac;")
                .addEntity(Observation.class)
                .setParameterList("routersId", routersId)
                .setParameter("dateFrom", event.getDateFrom())
                .setParameter("dateTo", event.getDateTo())
                .list();
        transaction.commit();

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
        List<Router> routers = (List<Router>) session.createQuery("from Router where event_id = (:id)")
                .setParameter("id", id)
                .list();
        transaction.commit();

        return routers;
    }

    private Event getEventById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event = (Event) session.createQuery("from Event where event_id = (:id)").setParameter("id", id).uniqueResult();
        transaction.commit();

        return event;
    }

}
