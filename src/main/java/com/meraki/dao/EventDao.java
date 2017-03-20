package com.meraki.dao;

import com.meraki.entity.Event;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface EventDao {

    public long createEvent(Event event);

    public Event updateEvent(Event event);

    public void deleteEvent(long id);

    public List<Event> getAllEvents();

    public Event getEvent(long id);

    public List<Event> getAllEvents(String eventName);


}
