package com.meraki.controller;

import com.meraki.entity.Observation;
import com.meraki.service.interfaces.EventService;
import com.meraki.statistics.StatisticService;
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
    @Qualifier("statisticService")
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Autowired
    @Qualifier("eventServiceImpl")
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping("/statistic/all")
    public String getStatisticAll() {
        return "statistic/statisticList";
    }

    @RequestMapping(value = "/statistic/select/event", method = RequestMethod.GET)
    public String getAllUniqueObservationsByEventId(@RequestParam("eventId") long eventId, Model model) {
        Set<Observation> resultSet = statisticService.getAllUniqueObservationsByEventId(eventId);
        model.addAttribute("observations", resultSet);
        model.addAttribute("events", eventService.getAllEvents());

        return "statistic/statisticList";
    }
}
