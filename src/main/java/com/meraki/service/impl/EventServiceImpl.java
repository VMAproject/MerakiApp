package com.meraki.service.impl;

import com.meraki.dao.EventDao;
import com.meraki.entity.Event;
import com.meraki.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {


    @Autowired
    private EventDao eventDao;


    @Override
    public Event findById(int id) {
        return eventDao.findById(id);
    }

    @Override
    public Event findByName(String name) {
        Event event = eventDao.findByName(name);
        return event;
    }

    @Override
    public void saveEvent(Event event) {
        eventDao.save(event);

    }

    @Override
    public void updateEvent(Event event) {
        Event entity = eventDao.findById(event.getId());
        if (entity != null) {
            entity.setName(event.getName());
            entity.setLocation(event.getLocation());
            entity.setRouters(event.getRouters());
        }

    }

    @Override
    public void deleteEventByName(String name) {
        eventDao.deleteByName(name);

    }

    @Override
    public List<Event> findAllEvents() {
        return eventDao.findAllEvents();
    }

    @Override
    public boolean isEventNameUnique(Integer id, String name) {
        Event event = eventDao.findByName(name);
        return (event == null || ((id != null) && (event.getId() == id)));
    }
}
