package com.meraki.dao;

import com.meraki.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface EventDao extends JpaRepository<Event, Long> {

    Event findByName(String name);
}
