package com.meraki.service.impl;

import com.meraki.dao.interfaces.EventDao;
import com.meraki.entity.Event;
import com.meraki.service.interfaces.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {


    @Autowired
    private EventDao eventDao;


    @Override
    public long createEvent(Event event) {
        return eventDao.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.updateEvent(event);
    }

    @Override
    public void deleteEvent(long id) {
        eventDao.deleteEvent(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDao.getAllEvents();
    }

    @Override
    public Event getEvent(long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public List<Event> getAllSearchEvents(List<Event> events) {
        events.sort((o1, o2) -> {
            int resCompare = String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
            return (resCompare != 0) ? resCompare : o1.getName().compareTo(o2.getName());
        });
        return events;
    }
}
