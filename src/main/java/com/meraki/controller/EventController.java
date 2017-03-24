package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.EventService;
import com.meraki.service.RouterService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @Autowired
    public void setRouterService(RouterService routerService) {
        this.routerService = routerService;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }


    @RequestMapping("/deleteEvent") /// удаление +
    public ModelAndView deleteEvent(@RequestParam long id) {
        eventService.deleteEvent(id);
        logger.info("delete event " + id);
        return new ModelAndView("redirect:getAllEventLists");
    }


    @RequestMapping(value = "/createEvent",method = RequestMethod.POST) /// добавление -
    public String saveEvent(@RequestParam String name,
                            @RequestParam String location,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
                            @RequestParam long id) {
        logger.info("save event ///");

        Event event = new Event();
        event.setName(name);
        event.setLocation(location);
        event.setDateFrom(dateFrom);
        event.setDateTo(dateTo);
        long eventId = eventService.createEvent(event);
        event = eventService.getEvent(eventId);
        Router router = routerService.getRouter(id);
        router.setEvent(event);
        routerService.updateRouter(router);

        return "eventList";
    }


    @RequestMapping("/getAllEventLists")  ///////// отображение всех евентов +
    public ModelAndView getAllEmployees() {
        List<Event> eventList = eventService.getAllEvents();
        logger.info("get all event" + eventList);
        return new ModelAndView("eventList", "eventList", eventList);
    }


//    @RequestMapping("createEvent")
//    public ModelAndView createEvent(@ModelAttribute Event event) {
//        logger.info("create event " + event);
//        return new ModelAndView("eventForm");
//
//    }

    @RequestMapping("editEvent")
    public ModelAndView editEvent(@RequestParam long id, @ModelAttribute Event event) {
        event = eventService.getEvent(id);
        logger.info("edit event " + event);
        return new ModelAndView("eventForm", "eventObject", event);
    }


    @RequestMapping("/events")
    public String eventsPage(Model model) {
        model.addAttribute("allRouters", routerService.getAllRouters());

        return "eventsPage";
    }
//
//
//    @RequestMapping(value = "createEvent", method = RequestMethod.POST)
//    public String createEvent(@RequestParam String name,
//                              @RequestParam String location,
//                              @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
//                              @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
//                              @RequestParam long id) {
//
//        Event event = new Event();
//        event.setName(name);
//        event.setLocation(location);
//        event.setDateFrom(dateFrom);
//        event.setDateTo(dateTo);
//        long eventId = eventService.createEvent(event);
//        event = eventService.getEvent(eventId);
//        Router router = routerService.getRouter(id);
//        router.setEvent(event);
//        routerService.updateRouter(router);
//
//        return "redirect:/getAllEventLists";
//    }
////

//
//    @RequestMapping("searchEvent")
//    public ModelAndView search(@RequestParam("searchName") String searchName) {
//        List<Event> eventList = eventService.getAllEvents(searchName);
//        return new ModelAndView("eventList", "eventList", eventList);
//    }
//

}
