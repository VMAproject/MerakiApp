package com.meraki.service;

import com.meraki.exception.NotFound;
import com.meraki.model.Event;

import java.util.List;


public interface EventService {

    Event createEvent(Event event);

    Event deleteEvent(long id);

    List<Event> findAllEvent();

    Event updateEvent(Event event);

    Event findByEventId(long id);


}
