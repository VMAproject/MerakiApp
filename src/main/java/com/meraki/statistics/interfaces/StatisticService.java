package com.meraki.statistics.interfaces;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;

import java.util.List;
import java.util.Set;

public interface StatisticService {

    Set<Observation> getAllUniqueObservationsByEventId(long id);

    List<Observation> getAllObservationsByEventId(long id);

    List<Router> getRoutersByEventId(long id);

    List<Observation> getObservationsByRouterId(long id);

}
