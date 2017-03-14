package com.meraki.dao;

import com.meraki.model.Router;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Verlamov on 14.03.17.
 */
public interface RouterDao extends JpaRepository<Router, Long> {

}
