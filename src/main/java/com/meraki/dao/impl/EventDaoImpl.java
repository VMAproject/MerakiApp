package com.meraki.dao.impl;

import com.meraki.dao.EventDao;
import com.meraki.entity.Event;
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
public class EventDaoImpl implements EventDao {

    private static final Logger logger = LoggerFactory.getLogger(EventDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEvent(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(event);
        logger.info("Event saved successfully, Event Details=" + event);
    }

    @Override
    public void updateEvent(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.update(event);
        logger.info("Event update successfully, Event Details=" + event);

    }

    @Override
    public void removeEvent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Event event = (Event) session.load(Event.class, new Integer(id));
        if (null != event) {
            session.delete(event);
        }
        logger.info("Event deleted successfully, Event details=" + event);
    }

    @Override
    public Event getEventById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Event event = (Event) session.load(Event.class, new Integer(id));
        logger.info("Event loaded successfully, Event details=" + event);
        return event;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getEventList() {
        Session session = sessionFactory.getCurrentSession();
        List<Event> eventList = session.createQuery("from Event ").list();
        for (Event event : eventList) {
            logger.info("Event List::" + event);
        }
        return eventList;
    }
}
