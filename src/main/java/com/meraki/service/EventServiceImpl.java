package com.meraki.service;

import com.meraki.dao.EventDao;

import com.meraki.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {


    @Autowired
//    @Resource
    private EventDao eventDao;

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event createEvent(Event event) {
        Event createdEvent = event;
        return eventDao.save(createdEvent);
    }

    @Override
    public Event deleteEvent(long id) {
        Event deleteEvent = eventDao.findOne(id);
        eventDao.delete(deleteEvent);
        return deleteEvent;


//        Event deletedEvent = eventDao.findOne(id);
//        if (deletedEvent == null ) {
//            throw new NotFound("no found");
//        }
//        eventDao.delete(deletedEvent);
//        return deletedEvent;
    }

    @Override
    public List<Event> findAllEvent() {
        return eventDao.findAll();
    }

    @Override
    public Event updateEvent(Event event) {

        Event updatedEvent = eventDao.findOne(event.getId());

        updatedEvent.setName(event.getName());
        updatedEvent.setLocation(event.getLocation());
//        updatedEvent.setDateFrom(event.getDateFrom());
//        updatedEvent.setDateTo(event.getDateTo());
        return updatedEvent;
    }

    @Override
    public Event findByEventId(long id) {
        return eventDao.findOne(id);
    }
}
