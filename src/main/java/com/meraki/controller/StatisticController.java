package com.meraki.controller;

import com.meraki.entity.Observation;
import com.meraki.service.interfaces.ObservationService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class StatisticController {


    private static final Logger logger = Logger.getLogger(StatisticController.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Autowired
    private ObservationService observationService;


//    @RequestMapping("/observations/all")
//    public String showAllObservation(Model model) {
//        model.addAttribute("observationList", observationService.getAllObservation());
//        return "observation/observationList";
//    }


    @RequestMapping("/observations/all")
    public ModelAndView getAllObservation() {
        ModelAndView modelAndView = new ModelAndView("observation/observationList");
        List<Observation> observationList = observationService.getAllObservation();
        modelAndView.addObject("observationList", observationList);
        return modelAndView;
    }


    @RequestMapping("/observation/uniq/event")
    public ModelAndView getAllUniq() {
        ModelAndView modelAndView = new ModelAndView("observation/observationList");

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
        ModelAndView modelAndView = new ModelAndView("observation/observationList");
        List<Observation> observationUniqueList = observationService.getAllUniqueObservation();
        modelAndView.addObject("observationUniqueList", observationUniqueList);
        return modelAndView;
    }


}
