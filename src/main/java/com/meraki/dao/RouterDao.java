package com.meraki.dao;

import com.meraki.entity.Router;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface RouterDao {

    List<Router> findAll();

    Router findByType(String type);

    Router findById(int id);


}
