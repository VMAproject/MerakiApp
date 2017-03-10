package com.meraki.controller;

import com.meraki.model.Event;
import com.meraki.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }


    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvent", this.eventService.findAllEvents());
        return "events";
    }


    @RequestMapping(value = "/events/add", method = RequestMethod.POST)
    public String addEvents(@ModelAttribute("event") Event event) {
        if (event.getEventId() == 0) {
            this.eventService.saveEvent(event);
        } else {
            this.eventService.updateEvent(event);
        }
        return "redirect:/events";
    }


    @RequestMapping(value = "remove/{eventId}")
    public String removeEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEventById(eventId);
        return "redirect:/events";
    }


    @RequestMapping(value = "edit/{eventId}")
    public String editEvent(@PathVariable("eventId") Long eventId, Model model) {
        model.addAttribute("event", this.eventService.findById(eventId));
        model.addAttribute("listEvent", this.eventService.findAllEvents());
        return "events";
    }
}
