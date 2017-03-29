package com.meraki.dao.impls;

import com.meraki.dao.interfaces.EventDao;
import com.meraki.entity.Event;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {

    private static final Logger logger = LoggerFactory.getLogger(EventDaoImpl.class);

    @Autowired
    private HibernateUtil hibernateUtil;


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
    public List<Event> getAllEvents(String eventName) {
        String query = "SELECT e.* FROM Event e WHERE e.name like '%" + eventName + "%'";
        List<Object[]> eventObjects = hibernateUtil.fetchAll(query);
        List<Event> events = new ArrayList<Event>();
        for (Object[] eventObject : eventObjects) ;
        Event event = new Event();
//        int id = ((BigInteger) eventObject[0]).longValue();
        return null;
    }
}
