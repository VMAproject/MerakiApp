package com.meraki.dao;

import com.meraki.entity.Event;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface EventDao {

    void addEvent(Event event);

    void updateEvent(Event event);

    void removeEvent(int id);

    Event getEventById(int id);

    List<Event> getEventList();

}
