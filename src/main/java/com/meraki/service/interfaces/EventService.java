package com.meraki.service.interfaces;

import com.meraki.entity.Event;

import java.util.List;


public interface EventService {

    long createEvent(Event event);

    Event updateEvent(Event event);

    void deleteEvent(long id);

    List<Event> getAllEvents();

    Event getEvent(long id);

    List<Event> getAllEvents(String eventName);

}
