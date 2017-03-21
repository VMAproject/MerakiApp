package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.EventService;
import com.meraki.service.RouterService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class EventController {

    private static final Logger logger = Logger.getLogger(EventController.class);

    @Autowired
    private EventService eventService;


    @Autowired
    private RouterService routerService;


    @RequestMapping("getAllEventLists")
    public ModelAndView getAllEmployees() {
        List<Event> eventList = eventService.getAllEvents();
        logger.info("get all event" + eventList);
        return new ModelAndView("eventList", "eventList", eventList);
    }


    @RequestMapping("createEvent")
    public ModelAndView createEvent(@ModelAttribute Event event) {
        logger.info("create event " + event);
        return new ModelAndView("eventForm");

    }

    @RequestMapping("editEvent")
    public ModelAndView editEvent(@RequestParam long id, @ModelAttribute Event event) {
        event = eventService.getEvent(id);
        logger.info("edit event " + event);
        return new ModelAndView("eventForm", "eventObject", event);
    }

    @RequestMapping("saveEvent")
    public ModelAndView saveEvent(@ModelAttribute Event event, HttpServletRequest request) {
        logger.info("save event " + event);
        int id = Integer.parseInt(request.getParameter("idr")); /// сделать коментарии а то пиздец

//        System.out.println(event.getDateFrom() + event.getDateTo().toString());

        Router router = routerService.getRouter(id);
//        router.setEvent(event);

        Set<Router> routerSet = new HashSet<>();
        routerSet.add(router);

        event.setRouters(routerSet);

//        routerService.updateRouter(router);
        if (event.getId() == 0) {
            eventService.createEvent(event);

        } else {
            eventService.updateEvent(event);
//            routerService.updateRouter(router);
        }

        logger.info("save event " + event);
        return new ModelAndView("redirect:getAllEventLists");
    }

    @RequestMapping("deleteEvent")
    public ModelAndView deleteEvent(@RequestParam long id) {
        eventService.deleteEvent(id);
        logger.info("delete event " + id);
        return new ModelAndView("redirect:getAllEventLists");
    }

    @RequestMapping("searchEvent")
    public ModelAndView search(@RequestParam("searchName") String searchName) {
        List<Event> eventList = eventService.getAllEvents(searchName);
        return new ModelAndView("eventList", "eventList", eventList);
    }


}
