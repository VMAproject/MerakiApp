package com.meraki.controller;

import com.meraki.entity.Observation;
import com.meraki.service.interfaces.EventService;
import com.meraki.statistics.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;


@Controller
public class StatisticController {

    private StatisticService statisticService;
    private EventService eventService;

    @Autowired
    @Qualifier("statisticServiceImpl")
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Autowired
    @Qualifier("eventServiceImpl")
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping("/statistic/all")
    public String getStatisticAll(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "statistic/statisticList";
    }

    @RequestMapping(value = "/statistic/select/event", method = RequestMethod.GET)
    public String getAllUniqueObservationsByEventId(@RequestParam("id") long eventId, Model model) {
        Set<Observation> resultSet = statisticService.getAllUniqueObservationsByEventId(eventId);

        model.addAttribute("observations", resultSet);
        model.addAttribute("amount", resultSet.size());

        return "statistic/statisticList";
    }
}
