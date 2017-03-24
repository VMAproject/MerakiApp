package com.meraki.service.impl;

import com.meraki.dao.StoreDao;
import com.meraki.entity.Store;
import com.meraki.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    public long createStore(Store store) {
        return storeDao.createStore(store);
    }

    @Override
    public Store updateStore(Store store) {
        return storeDao.updateStore(store);
    }

    @Override
    public void deleteStore(long id) {
        storeDao.deleteStore(id);
    }

    @Override
    public List<Store> getAllStore() {
        return storeDao.getAllStore();
    }

    @Override
    public Store getStore(long id) {
        return storeDao.getStore(id);
    }
}
