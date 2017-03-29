package com.meraki.statistics.dao.interfaces;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;

import java.util.List;

/**
 * Created by Verlamov on 29.03.17.
 */
public interface StatisticDao {

    List<Router> getRoutersByEventId(long id);

    List<Observation> getObservationsByRouterId(long id);
}
