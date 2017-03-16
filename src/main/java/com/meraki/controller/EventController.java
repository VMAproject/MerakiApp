package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventList", this.eventService.getEventList());
        return "event";
    }


    //For add and update EVENT both

    @RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("event") Event event) {
        if (event.getEventId() == 0) {
            //new event, add it
            this.eventService.addEvent(event);
        } else {
            //existing event, call update
            this.eventService.updateEvent(event);
        }
        return "redirect:/events";
    }


    @RequestMapping(value = "/remove/{id}")
    public String removeEvent(@PathVariable("id") int id) {
        this.eventService.removeEvent(id);
        return "redirect:/events";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editEvent(@PathVariable("id") int id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        model.addAttribute("eventList", eventService.getEventList());
        return "event";
    }

    @RequestMapping("/router/{id}")
    public ModelAndView viewRouters(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("router");
        modelAndView.addObject("routerList", eventService.getEventWithRouterById(id).getRouterList());
        Router router = new Router();
        router.setEventId(id);
        modelAndView.addObject("router", router);
        return modelAndView;
    }

}
