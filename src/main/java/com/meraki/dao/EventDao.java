package com.meraki.dao;

import com.meraki.entity.Event;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface EventDao {

    Event findById(int id);

    Event findByName(String name);

    void save(Event event);

    void deleteByName(String name);

    List<Event> findAllEvents();

}
