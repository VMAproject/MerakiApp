package com.meraki.dao.impls;

import com.meraki.dao.interfaces.StoreDao;
import com.meraki.entity.Store;
import com.meraki.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDaoImpl implements StoreDao {

    private static final Logger logger = LoggerFactory.getLogger(StoreDaoImpl.class);
    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createStore(Store store) {
        logger.info("*** Store Dao *** create Store => " + store);
        return (Long) hibernateUtil.create(store);
    }

    @Override
    public Store updateStore(Store store) {
        logger.info("*** Store Dao *** update Store => " + store);
        return hibernateUtil.update(store);
    }

    @Override
    public void deleteStore(long id) {
        Store store = new Store();
        store.getId();
        logger.info("*** Store Dao *** delete Store for ID => " + id);
        hibernateUtil.delete(store);
    }

    @Override
    public List<Store> getAllStore() {
        logger.info("*** Store Dao *** get All Store => " + Store.class);
        return hibernateUtil.fetchAll(Store.class);
    }

    @Override
    public Store getStore(long id) {
        logger.info("*** Store Dao *** get Store => " + id + Store.class);
        return hibernateUtil.fetchById(id, Store.class);
    }
}
