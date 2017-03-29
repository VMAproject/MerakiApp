package com.meraki.statistics.dao.interfaces;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;

import java.util.List;

public interface StatisticDao {

    List<Router> getRoutersByEventId(long id);

    List<Router> getRoutersByStoreId(long id);

    List<Observation> getObservationsByRouterId(long id);

}
