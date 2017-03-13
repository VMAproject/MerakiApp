package com.meraki.service;

import com.meraki.model.Event;

import java.util.List;


public interface EventService {

    Event findById(Long eventId);

    Event findName(String name);

    void saveEvent(Event event);

    void updateEvent(Event event);

    void deleteEventById(Long eventId);

    void deleteAllEvent();

    List<Event> findAllEvents();


}
