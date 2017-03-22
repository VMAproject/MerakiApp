package com.meraki.service.impl;

import com.meraki.dao.ObservationDao;
import com.meraki.entity.Observation;
import com.meraki.service.ObservationService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Verlamov on 22.03.17.
 */

@Service
@Transactional
public class ObservationServiceImpl implements ObservationService {


    @Autowired
    private ObservationDao observationDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long createObservation(Observation observation) {
        return observationDao.createObservation(observation);
    }

    @Override
    public Observation updateObservation(Observation observation) {
        return observationDao.updateObservation(observation);
    }

    @Override
    public void deleteObservation(long id) {
        observationDao.deleteObservation(id);
    }

    @Override
    public List<Observation> getAllObservation() {
        return observationDao.getAllObservation();
    }

    @Override
    public Observation getObservation(long id) {
        return observationDao.getObservation(id);
    }

    @Override
    public List<Observation> getAllUniqueObservation() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT * FROM miraki2.observations WHERE rssi > 15 GROUP BY clientMac ORDER BY seenTime ASC");
        return query.list();
    }
}