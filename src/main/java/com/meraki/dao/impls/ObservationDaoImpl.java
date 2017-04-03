package com.meraki.dao.impls;

import com.meraki.dao.interfaces.ObservationDao;
import com.meraki.entity.Observation;
import com.meraki.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ObservationDaoImpl implements ObservationDao {

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
