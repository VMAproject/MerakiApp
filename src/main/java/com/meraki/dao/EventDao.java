package com.meraki.dao;

import com.meraki.entity.Event;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface EventDao {

     long createEvent(Event event);

     Event updateEvent(Event event);

     void deleteEvent(long id);

     List<Event> getAllEvents();

     Event getEvent(long id);

     List<Event> getAllEvents(String eventName);


}
