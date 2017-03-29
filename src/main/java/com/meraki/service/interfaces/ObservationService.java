package com.meraki.service.interfaces;

import com.meraki.entity.Observation;

import java.util.List;

public interface ObservationService {

    long createObservation(Observation observation);

    Observation updateObservation(Observation observation);

    void deleteObservation(long id);

    List<Observation> getAllObservation();

    Observation getObservation(long id);

    List<Observation> getAllUniqueObservation();


}
