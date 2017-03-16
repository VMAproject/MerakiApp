package com.meraki.service;

import com.meraki.entity.Event;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface EventService {

    void addEvent(Event event);

    void updateEvent(Event event);

    void removeEvent(int id);

    Event getEventById(int id);

    List<Event> getEventList();

    Event getEventWithRouterById(int id);
}
