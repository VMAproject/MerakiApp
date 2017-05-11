package com.meraki.controller;

import com.meraki.entity.Observation;
import com.meraki.service.interfaces.EventService;
import com.meraki.service.interfaces.StoreService;
import com.meraki.statistics.service.impls.StatisticServiceImpl;
import com.meraki.statistics.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class StatisticController {

    private StatisticService statisticService;
    private EventService eventService;
    private StoreService storeService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping("/statistic/all")
    public String getStatisticAll(Model model) {

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("stores", storeService.getAllStore());

        return "statistic/statisticList";
    }

    @RequestMapping(value = "/statistic/compare", method = RequestMethod.GET)
    public String compareEventToStore(@RequestParam(value = "eventId") long eventId,
                                      @RequestParam(value = "storeId") long storeId,
                                      Model model) {

        Long[] storesId = {storeId};
        List<Observation> resultList = statisticService.getUniqueStoreVisitorsByEventId(eventId, storesId);

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("stores", storeService.getAllStore());
        model.addAttribute("observations", resultList);
        model.addAttribute("amount", resultList.size());

        return "statistic/statisticList";
    }
}
