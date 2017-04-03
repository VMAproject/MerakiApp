package com.meraki.dao.impls;

import com.meraki.dao.interfaces.EventDao;
import com.meraki.entity.Event;
import com.meraki.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    @Autowired
    private HibernateUtil hibernateUtil;

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long createEvent(Event event) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        long loadedEventId = (long) session.save(event);
        transaction.commit();
        session.close();

        return loadedEventId;
    }

    @Override
    public Event updateEvent(Event event) {
        return hibernateUtil.update(event);
    }

    @Override
    public void deleteEvent(long id) {
        Event event = getEvent(id);
        if (event != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from Event e where e.id = :id").setLong("id", id).executeUpdate();
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<Event> getAllEvents() {
        return hibernateUtil.fetchAll(Event.class);
    }

    @Override
    public Event getEvent(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event loadedEvent = (Event) session.get(Event.class, id);
        transaction.commit();
        session.close();

        return loadedEvent;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAllEvents(String eventName) {
        String query = "SELECT e.* FROM Event e WHERE e.name like '%" + eventName + "%'";
        List<Object[]> eventObjects = hibernateUtil.fetchAll(query);
        List<Event> events = new ArrayList<Event>();
        for (Object[] eventObject : eventObjects) ;
        Event event = new Event();
//        int id = ((BigInteger) eventObject[0]).longValue();
        return null;
    }

    @Override
    public boolean existsEventById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        boolean exists = session.createQuery("from Event e where e.id = " + id).uniqueResult() != null;
        transaction.commit();
        session.close();

        return exists;
    }
}
