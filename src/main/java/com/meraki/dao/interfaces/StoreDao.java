package com.meraki.dao.interfaces;

import com.meraki.entity.Store;

import java.util.List;

/**
 * Created by Verlamov on 24.03.17.
 */
public interface StoreDao {

    long createStore(Store store);

    Store updateStore(Store store);

    void deleteStore(long id);

    List<Store> getAllStore();

    Store getStore(long id);

}
