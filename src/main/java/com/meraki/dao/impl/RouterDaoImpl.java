package com.meraki.dao.impl;

import com.meraki.dao.AbstractDao;
import com.meraki.dao.RouterDao;
import com.meraki.entity.Router;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */

@Repository("routerDao")
public class RouterDaoImpl extends AbstractDao<Integer, Router> implements RouterDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Router> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("type"));
        return (List<Router>) criteria.list();
    }

    @Override
    public Router findByType(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("type", type));
        return (Router) criteria.uniqueResult();
    }

    @Override
    public Router findById(int id) {
        return getByKey(id);
    }
}
