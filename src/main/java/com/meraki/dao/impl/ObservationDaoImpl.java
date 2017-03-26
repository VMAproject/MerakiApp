package com.meraki.dao.impl;

import com.meraki.dao.interfaces.ObservationDao;
import com.meraki.entity.Observation;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Verlamov on 22.03.17.
 */
@Repository
public class ObservationDaoImpl implements ObservationDao {

    private static final Logger logger = LoggerFactory.getLogger(ObservationDaoImpl.class);


    @Autowired
    private HibernateUtil hibernateUtil;


    @Override
    public long createObservation(Observation observation) {
        return (Long) hibernateUtil.create(observation);
    }

    @Override
    public Observation updateObservation(Observation observation) {
        return hibernateUtil.update(observation);
    }

    @Override
    public void deleteObservation(long id) {
        Observation observation = new Observation();
        observation.setId(id);
        hibernateUtil.delete(observation);
    }

    @Override
    public List<Observation> getAllObservation() {
        return hibernateUtil.fetchAll(Observation.class);
    }

    @Override
    public Observation getObservation(long id) {
        return hibernateUtil.fetchById(id, Observation.class);
    }

    @Override
    public List<Observation> getAllUniqueObservation() {
        return hibernateUtil.fetchAllU(Observation.class);
    }
}
