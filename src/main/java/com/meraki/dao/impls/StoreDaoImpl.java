package com.meraki.dao.impls;

import com.meraki.dao.interfaces.StoreDao;
import com.meraki.entity.Event;
import com.meraki.entity.Store;
import com.meraki.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired
    private HibernateUtil hibernateUtil;

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long createStore(Store store) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        long loadedStoreId = (long) session.save(store);
        transaction.commit();
        session.close();

        return loadedStoreId;
    }

    @Override
    public Store updateStore(Store store) {
        return hibernateUtil.update(store);
    }

    @Override
    public void deleteStore(long id) {
        Store store = getStore(id);
        if (store != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from Store s where s.id = :id").setLong("id", id).executeUpdate();
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<Store> getAllStore() {
        return hibernateUtil.fetchAll(Store.class);
    }

    @Override
    public Store getStore(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Store loadedStore = (Store) session.get(Store.class, id);
        transaction.commit();
        session.close();

        return loadedStore;
    }
}
