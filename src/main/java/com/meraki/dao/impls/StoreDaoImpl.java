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

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createStore(Store store) {
        return (Long) hibernateUtil.create(store);
    }

    @Override
    public Store updateStore(Store store) {
        return hibernateUtil.update(store);
    }

    @Override
    public void deleteStore(long id) {
        Store store = new Store();
        store.getId();
        hibernateUtil.delete(store);
    }

    @Override
    public List<Store> getAllStore() {
        return hibernateUtil.fetchAll(Store.class);
    }

    @Override
    public Store getStore(long id) {
        return hibernateUtil.fetchById(id, Store.class);
    }
}
