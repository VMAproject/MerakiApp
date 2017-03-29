package com.meraki.service.interfaces;

import com.meraki.entity.Observation;

import java.util.List;

/**
 * Created by Verlamov on 22.03.17.
 */
public interface ObservationService {

    long createObservation(Observation observation);

    Observation updateObservation(Observation observation);

    void deleteObservation(long id);

    List<Observation> getAllObservation();

    Observation getObservation(long id);

    List<Observation> getAllUniqueObservation();


}
