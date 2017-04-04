package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Observation;
import com.meraki.entity.Store;
import com.meraki.service.interfaces.EventService;
import com.meraki.service.interfaces.StoreService;
import com.meraki.statistics.service.impls.StatisticServiceImpl2;
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
    @Autowired
    private StatisticServiceImpl2 statisticServiceImpl2;
    private EventService eventService;
    private StoreService storeService;

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

    @Autowired
    @Qualifier("storeServiceImpl")
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping("/statistic/all")
    public String getStatisticAll(Model model) {

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("stores", storeService.getAllStore());

        return "statistic/statisticList";
    }

//    @RequestMapping(value = "/statistic/select/event", method = RequestMethod.GET)
//    public String getAllUniqueObservationsByEventId(@RequestParam("eventId") long eventId,
//                                                    Model model) {
//
//        Set<Observation> resultSet = statisticService.getAllUniqueObservationsByEventId(eventId);
//
//        model.addAttribute("events", eventService.getAllEvents());
//        model.addAttribute("stores", storeService.getAllStore());
//        model.addAttribute("observations", resultSet);
//        model.addAttribute("amount", resultSet.size());
//
//        return "statistic/statisticList";
//    }

    @RequestMapping(value = "/statistic/select/event", method = RequestMethod.GET)
    public String getAllUniqueObservationsByEventId(@RequestParam("eventId") long eventId,
                                                    Model model) {

        List<Observation> resultSet = statisticServiceImpl2.getAllUniqueClientsByEventId(eventId);

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("stores", storeService.getAllStore());
        model.addAttribute("observations", resultSet);
        model.addAttribute("amount", resultSet.size());

        return "statistic/statisticList";
    }

    @RequestMapping(value = "/statistic/select/store", method = RequestMethod.GET)
    public String getAllUniqueObservationsByStoreId(@RequestParam("storeId") long storeId,
                                                    Model model) {

        Set<Observation> resultSet = statisticService.getAllUniqueObservationsByStoreId(storeId);

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("stores", storeService.getAllStore());
        model.addAttribute("observations", resultSet);
        model.addAttribute("amount", resultSet.size());

        return "statistic/statisticList";
    }

    @RequestMapping(value = "/statistic/compare", method = RequestMethod.GET)
    public String compareEventToStore(@RequestParam(value = "eventId") long eventId,
                                      @RequestParam(value = "storeId") long storeId,
                                      Model model) {

        Event loadedEvent = eventService.getEvent(eventId);
        Store loadedStore = storeService.getStore(storeId);

        Set<Observation> resultSet = statisticService.compareEventToStore(loadedEvent, loadedStore);

        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("stores", storeService.getAllStore());
        model.addAttribute("observations", resultSet);
        model.addAttribute("amount", resultSet.size());

        return "statistic/statisticList";
    }
}
