package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.interfaces.EventService;
import com.meraki.service.interfaces.RouterService;
import com.meraki.statistics.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class EventController {

    private EventService eventService;
    private RouterService routerService;
    private StatisticService statisticService;

    @Autowired
    @Qualifier("eventServiceImpl")
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    @Qualifier("routerServiceImpl")
    public void setRouterService(RouterService routerService) {
        this.routerService = routerService;
    }

    @Autowired
    @Qualifier("statisticServiceImpl")
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    //====================================== Methods ==============================================

    @RequestMapping(value = "/events/add")
    public String addEvent(Model model) {
        model.addAttribute("routers", routerService.getAllRouters());
        return "event/eventForm";
    }

    @RequestMapping(value = "/events/edit", method = RequestMethod.GET)
    public String editEvent(@RequestParam long id,
                            Model model) {

        Event event = eventService.getEvent(id);
        model.addAttribute("eventId", event.getId());
        model.addAttribute("eventName", event.getName());
        model.addAttribute("eventLocation", event.getLocation());
        model.addAttribute("eventDateFrom", event.getDateFrom());
        model.addAttribute("eventDateTo", event.getDateTo());
        model.addAttribute("routers", routerService.getAllRouters());

        return "event/eventForm";
    }

    @RequestMapping(value = "/events/createOrUpdate", method = RequestMethod.GET)
    public String createOrUpdateEvent(@RequestParam String eventId,
                                      @RequestParam String name,
                                      @RequestParam String location,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
                                      @RequestParam long routerId) {

        Event event = new Event();
        if (eventId.isEmpty()) {
            event.setName(name);
            event.setLocation(location);
            event.setDateFrom(dateFrom);
            event.setDateTo(dateTo);
            eventService.createEvent(event);

            Router router = routerService.getRouter(routerId);
            router.setEvent(event);
            routerService.updateRouter(router);
        } else {
            event.setId(new Long(eventId));
            event.setName(name);
            event.setLocation(location);
            event.setDateFrom(dateFrom);
            event.setDateTo(dateTo);
            eventService.updateEvent(event);

            Router router = routerService.getRouter(routerId);
            router.setEvent(event);
            routerService.updateRouter(router);
        }

        return "redirect:/events/all";
    }

//    @RequestMapping("/events/delete")
//    public String deleteStore(@RequestParam("id") long id) {
//
//        List<Router> routers = statisticService.getRoutersByEventId(id);
//        for (Router router : routers) {
//            router.setEvent(null);
//            routerService.updateRouter(router);
//        }
//
//        eventService.deleteStore(id);
//
//        return "redirect:/events/all";
//    }

    @RequestMapping("/events/all")
    public String showEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "event/eventList";
    }

}
