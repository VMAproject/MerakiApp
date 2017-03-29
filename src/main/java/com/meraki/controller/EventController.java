package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.interfaces.EventService;
import com.meraki.service.interfaces.RouterService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
public class EventController {

    private static final Logger logger = Logger.getLogger(EventController.class);

    private EventService eventService;

    private RouterService routerService;

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

    @RequestMapping("/events/add")
    public String addEvent(Model model) {
        model.addAttribute("routersList", routerService.getAllRouters());
        logger.info("*** Event Controller *** add Event => " + model);
        return "event/eventForm";
    }

    @RequestMapping(value = "/events/create", method = RequestMethod.GET)
    public String createEvent(@RequestParam String name,
                              @RequestParam String location,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
                              @RequestParam long id) {

        Event event = new Event();
        event.setName(name);
        event.setLocation(location);
        event.setDateFrom(dateFrom);
        event.setDateTo(dateTo);
        long eventId = eventService.createEvent(event);
        event.setId(eventId);
        Router router = routerService.getRouter(id);
        router.setEvent(event);
        logger.info("*** Event Controller *** create Event =>" + name + location + dateFrom + dateTo + router);
        routerService.updateRouter(router);

        return "redirect:/events/all";
    }

    @RequestMapping("/events/all")
    public String showEvents(Model model) {
        logger.info("*** Event Controller *** show Events => " + model);
        model.addAttribute("eventsList", eventService.getAllEvents());
        return "event/eventList";
    }

}
