package com.meraki.service;

import com.meraki.model.Router;

import java.util.List;

public interface RouterService {

    List<Router> findAllRouter();

    Router findByRouterId(long id);
}
