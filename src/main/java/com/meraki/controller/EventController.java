package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.interfaces.EventService;
import com.meraki.service.interfaces.RouterService;
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

import java.util.Date;


@Controller
public class EventController {

    private static final Logger logger = Logger.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private RouterService routerService;

    @RequestMapping("/deleteEvent") /// удаление +
    public ModelAndView deleteEvent(@RequestParam long id) {
        eventService.deleteEvent(id);
        logger.info("delete event " + id);
        return new ModelAndView("redirect:/events/all");
    }


    @RequestMapping("/editEvent")/// изменение
    public ModelAndView editEvent(@RequestParam long id, @ModelAttribute Event event) {
        event = eventService.getEvent(id);
        logger.info("edit event " + event);
        return new ModelAndView("eventForm", "eventObject", event);
    }


    @RequestMapping("/events")
    public String eventsPage(Model model) {
        model.addAttribute("allRouters", routerService.getAllRouters());
        return "eventForm";
    }

    @RequestMapping(value = "/events/add", method = RequestMethod.GET)
    public String addEvent(@RequestParam String name,
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
        event = eventService.getEvent(eventId);
        Router router = routerService.getRouter(id);
        router.setEvent(event);
        routerService.updateRouter(router);


        return "redirect:/events/all";
    }

    @RequestMapping("/events/all")
    public String showEvents(Model model) {
        model.addAttribute("allEvents", eventService.getAllEvents());
        return "eventList";
    }


//    @RequestMapping("createEvent")
//    public ModelAndView createEvent(@ModelAttribute Event event) {
//        logger.info("create event " + event);
//        return new ModelAndView("eventForm");
//
//    }


//
//    @RequestMapping("searchEvent")
//    public ModelAndView search(@RequestParam("searchName") String searchName) {
//        List<Event> eventList = eventService.getAllEvents(searchName);
//        return new ModelAndView("eventList", "eventList", eventList);
//    }
//

}
