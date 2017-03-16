package com.meraki.service;

import com.meraki.entity.Router;

import java.util.List;

/**
 * Created by Verlamov on 15.03.17.
 */
public interface RouterService {

    Router findById(int id);

    Router findByType(String type);

    List<Router> findAll();


}
