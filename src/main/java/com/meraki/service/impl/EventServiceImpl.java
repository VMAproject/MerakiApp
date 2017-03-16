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

@Service
@Transactional
public class EventServiceImpl implements EventService {


    @Autowired
    private EventDao eventDao;

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }


    @Override
    public void addEvent(Event event) {
        eventDao.addEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventDao.updateEvent(event);
    }

    @Override
    public void removeEvent(int id) {
        eventDao.removeEvent(id);

    }

    @Override
    public Event getEventById(int id) {
        return eventDao.getEventById(id);
    }

    @Override
    public List<Event> getEventList() {
        return eventDao.getEventList();
    }

    @Override
    public Event getEventWithRouterById(int id) {
        Event event = eventDao.getEventById(id);
        event.getRouters().size();
        return event;
    }
}
