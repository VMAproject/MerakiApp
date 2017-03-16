package com.meraki.service;

import com.meraki.entity.Event;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface EventService {


    Event findById(int id);

    Event findByName(String name);

    void saveEvent(Event event);

    void updateEvent(Event event);

    void deleteEventByName(String name);

    List<Event> findAllEvents();

    boolean isEventNameUnique(Integer id, String name);
}
