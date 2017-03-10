package com.meraki.service;

import com.meraki.dao.EventDao;
import com.meraki.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private EventDao eventDao;


    @Override
    public Event findById(Long eventId) {
        return eventDao.findOne(eventId);
    }

    @Override
    public Event findName(String name) {
        return eventDao.findByName(name);
    }

    @Override
    public void saveEvent(Event event) {
       eventDao.save(event);
    }

    @Override
    public void updateEvent(Event event) {
        saveEvent(event);

    }

    @Override
    public void deleteEventById(Long eventId) {
        eventDao.delete(eventId);

    }

    @Override
    public void deleteAllEvent() {
        eventDao.deleteAll();

    }

    @Override
    public List<Event> findAllEvents() {
        return this.eventDao.findAll();
    }


}
