package com.meraki.statistics.service.impls;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Store;
import com.meraki.service.interfaces.EventService;
import com.meraki.statistics.dao.interfaces.StatisticDao;
import com.meraki.statistics.service.interfaces.StatisticService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    private StatisticDao statisticDao;

    @Autowired
    public void setStatisticDao(StatisticDao statisticDao) {
        this.statisticDao = statisticDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> getUniqueStoreVisitorsByEventId(Long id, Long[] storesId) {
        return statisticDao.getUniqueStoreVisitorsByEventId(id, storesId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> getUniqueEventVisitors(Event event) {
        return statisticDao.getUniqueEventVisitors(event);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Observation> getUniqueStoreVisitors(Date dateFrom, Long[] storesId) {
        return statisticDao.getUniqueStoreVisitors(dateFrom, storesId);
    }
}
