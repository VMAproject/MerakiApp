package com.meraki.statistics.dao.interfaces;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Router;

import java.util.Date;
import java.util.List;

public interface StatisticDao {

    List<Observation> getUniqueStoreVisitorsByEventId(Long id, Long[] storesId);

    List<Observation> getUniqueEventVisitors(Event event);

    List<Observation> getUniqueStoreVisitors(Date dateFrom, Long[] storesId);

}
