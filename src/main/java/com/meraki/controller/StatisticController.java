package com.meraki.controller;

import com.meraki.entity.Observation;
import com.meraki.service.ObservationService;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Verlamov on 21.03.17.
 */

@Controller
public class StatisticController {


    private static final Logger logger = Logger.getLogger(StatisticController.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ObservationService observationService;


    @RequestMapping("getAllObservationLists")
    public ModelAndView getAllObservation() {
        ModelAndView modelAndView = new ModelAndView("observationList");
        List<Observation> observationList = observationService.getAllObservation();
        modelAndView.addObject("observationList", observationList);
        return modelAndView;
    }


    //    @RequestMapping("getAllObservationUniqueLists")
//    public ModelAndView getAllObservationUniqueLists() {
//        ModelAndView modelAndView = new ModelAndView("observationList");
//        List<Observation> observationUniqueList = observationService.getAllUniqueObservation();
//        modelAndView.addObject("observationUniqueList", observationUniqueList);
//        return modelAndView;
//    }
    @RequestMapping("getAllObservationUniqueLists")
    public ModelAndView getAllObservationUniqueLists() {
        ModelAndView modelAndView = new ModelAndView("observationList");
        List<Observation> observationUniqueList = sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM meraki_db.observation WHERE rssi > 15 GROUP BY clientMac").list();
        modelAndView.addObject("observationUniqueList", observationUniqueList);
        return modelAndView;
    }


}
