package com.meraki.service;

import com.meraki.model.Router;

import java.util.List;

/**
 * Created by Verlamov on 14.03.17.
 */
public interface RouterService {

    List<Router> findAllRouter();

    Router findByRouterId(long id);
}
