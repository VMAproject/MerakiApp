package com.meraki.dao.impls;

import com.meraki.dao.interfaces.EventDao;
import com.meraki.entity.Event;
import com.meraki.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    private static final Logger logger = LoggerFactory.getLogger(EventDaoImpl.class);

    @Autowired
    private HibernateUtil hibernateUtil;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long createEvent(Event event) {
        return (Long) hibernateUtil.create(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return hibernateUtil.update(event);
    }

    @Override
    public void deleteEvent(long id) {
        Event event = new Event();
        event.setId(id);
        hibernateUtil.delete(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return hibernateUtil.fetchAll(Event.class);
    }

    @Override
    public Event getEvent(long id) {
        return hibernateUtil.fetchById(id, Event.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAllSearchEvents(String eventName) {
       return getCurrentSession().createQuery("from Event where name like \'%" + eventName + "%'").list();

    }
}
