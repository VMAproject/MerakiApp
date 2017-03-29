package com.meraki.dao.impls;

import com.meraki.dao.interfaces.ObservationDao;
import com.meraki.entity.Observation;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ObservationDaoImpl implements ObservationDao {

    private static final Logger logger = LoggerFactory.getLogger(ObservationDaoImpl.class);


    @Autowired
    private HibernateUtil hibernateUtil;


    @Override
    public long createObservation(Observation observation) {
        logger.info("*** Observation Dao *** create Observation =>" + observation);
        return (Long) hibernateUtil.create(observation);
    }

    @Override
    public Observation updateObservation(Observation observation) {
        logger.info("*** Observation Dao *** update Observation =>" + observation);
        return hibernateUtil.update(observation);
    }

    @Override
    public void deleteObservation(long id) {
        Observation observation = new Observation();
        observation.setId(id);
        logger.info("*** Observation Dao *** delete Observation for ID =>" + id);
        hibernateUtil.delete(observation);
    }

    @Override
    public List<Observation> getAllObservation() {
        logger.info("*** Observation Dao *** get All Observation =>" + Observation.class);
        return hibernateUtil.fetchAll(Observation.class);
    }

    @Override
    public Observation getObservation(long id) {
        logger.info("*** Observation Dao *** get Observation for ID =>" + Observation.class);
        return hibernateUtil.fetchById(id, Observation.class);
    }

    @Override
    public List<Observation> getAllUniqueObservation() {
        logger.info("*** Observation Dao *** get All Unique Observation =>" +Observation.class);
        return hibernateUtil.fetchAllU(Observation.class);
    }
}
