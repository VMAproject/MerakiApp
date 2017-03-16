package com.meraki.dao.impl;

import com.meraki.dao.AbstractDao;
import com.meraki.dao.EventDao;
import com.meraki.entity.Event;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */

@Repository("eventDao")
public class EventDaoImpl extends AbstractDao<Integer, Event> implements EventDao {
    @Override
    public Event findById(int id) {
        Event event = getByKey(id);
        if (event != null) {
            Hibernate.initialize(event.getRouters());
        }
        return event;
    }

    @Override
    public Event findByName(String name) {
        System.out.println("Event name" + name); /// псевдо логирование
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        Event event = (Event) criteria.uniqueResult();
        if (event != null) {
            Hibernate.initialize(event.getRouters());
        }
        return event;
    }

    @Override
    public void save(Event event) {
        persist(event);

    }

    @Override
    public void deleteByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        Event event = (Event) criteria.uniqueResult();
        delete(event);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> findAllEvents() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("location"));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Event> events = (List<Event>) criteria.list();
        return events;
    }
}
