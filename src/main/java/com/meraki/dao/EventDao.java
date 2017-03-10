package com.meraki.dao;

import com.meraki.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventDao extends JpaRepository<Event, Long> {

    Event findByName(String name);
}
