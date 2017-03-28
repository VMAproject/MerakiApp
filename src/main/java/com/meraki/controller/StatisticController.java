package com.meraki.controller;

import com.meraki.entity.Observation;
import com.meraki.statistics.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    @Qualifier("statisticService")
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @RequestMapping("/statistic/all")
    public String getStatisticAll() {
        return "statistic/statisticList";
    }

    @RequestMapping(value = "/statistic/select/event", method = RequestMethod.GET)
    public String getAllUniqueObservationsByEventId(@RequestParam("eventId") long eventId, Model model) {
        List<Observation> resultList = statisticService.getAllUniqueObservationsByEventId(eventId);
        model.addAttribute("observations", resultList);

        return "statistic/statisticList";
    }
}
