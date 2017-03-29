package com.meraki.statistics.service.interfaces;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;

import java.util.List;
import java.util.Set;

public interface StatisticService {

    Set<Observation> getAllUniqueObservationsByEventId(long id);

    Set<Observation> getAllUniqueObservationsByStoreId(long id);

    List<Observation> getAllObservationsByEventId(long id);

    List<Observation> getAllObservationsByStoreId(long id);

    List<Router> getRoutersByEventId(long id);

    List<Router> getRoutersByStoreId(long id);

    List<Observation> getObservationsByRouterId(long id);

}
