package com.meraki.statistics.service.interfaces;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import com.meraki.entity.Store;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface StatisticService {

    List<Observation> getUniqueStoreVisitorsByEventId(Long id, Long[] storesId);

    List<Observation> getUniqueEventVisitors(Event event);

    List<Observation> getUniqueStoreVisitors(Date dateFrom, Long[] storesId);

}
