package com.meraki.statistics.service.impls;

import com.meraki.entity.Observation;
import com.meraki.entity.Router;
import com.meraki.statistics.dao.interfaces.StatisticDao;
import com.meraki.statistics.service.interfaces.StatisticService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatisticServiceImpl implements StatisticService {

    private StatisticDao statisticDao;

    @Autowired
    @Qualifier("statisticDaoImpl")
    public void setStatisticDao(StatisticDao statisticDao) {
        this.statisticDao = statisticDao;
    }

    @Override
    public Set<Observation> getAllUniqueObservationsByEventId(long id) {
        Set<Observation> resultSet = new HashSet<>();

        List<Observation> listWithoutUniqueness = getAllObservationsByEventId(id);
        List<Observation> listWithConsideringRssi = new ArrayList<>();
        for (Observation obsv : listWithoutUniqueness) {
            if (obsv.getRssi() >= 15) {
                listWithConsideringRssi.add(obsv);
            }
        }
        resultSet.addAll(listWithConsideringRssi);

        return resultSet;
    }

    @Override
    public Set<Observation> getAllUniqueObservationsByStoreId(long id) {
        Set<Observation> resultSet = new HashSet<>();

        List<Observation> listWithoutUniqueness = getAllObservationsByStoreId(id);
        List<Observation> listWithConsideringRssi = new ArrayList<>();
        for (Observation obsv : listWithoutUniqueness) {
            if (obsv.getRssi() >= 15) {
                listWithConsideringRssi.add(obsv);
            }
        }
        resultSet.addAll(listWithConsideringRssi);

        return resultSet;
    }

    @Override
    public List<Observation> getAllObservationsByEventId(long id) {
        List<Observation> resultSet = new ArrayList<>();

        List<Router> loadedRouters = getRoutersByEventId(id);

        List<Observation> tempList;
        for (Router router : loadedRouters) {
            tempList = getObservationsByRouterId(router.getId());
            resultSet.addAll(tempList);
        }

        return resultSet;
    }

    @Override
    public List<Observation> getAllObservationsByStoreId(long id) {
        List<Observation> resultSet = new ArrayList<>();

        List<Router> loadedRouters = getRoutersByStoreId(id);

        List<Observation> tempList;
        for (Router router : loadedRouters) {
            tempList = getObservationsByRouterId(router.getId());
            resultSet.addAll(tempList);
        }

        return resultSet;
    }

    @Override
    public List<Router> getRoutersByEventId(long id) {
        return statisticDao.getRoutersByEventId(id);
    }

    @Override
    public List<Router> getRoutersByStoreId(long id) {
        return statisticDao.getRoutersByStoreId(id);
    }

    @Override
    public List<Observation> getObservationsByRouterId(long id) {
        return statisticDao.getObservationsByRouterId(id);
    }

}
