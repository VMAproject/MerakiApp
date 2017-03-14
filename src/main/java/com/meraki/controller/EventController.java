package com.meraki.controller;


import com.meraki.model.Event;
import com.meraki.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EventController {

    @Autowired
    private EventService eventService;


    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }


    @RequestMapping(value = "events", method = RequestMethod.GET)
    public String listEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvent", this.eventService.findAllEvent());
        return "events";
    }

    @RequestMapping(value = "/events/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("event") Event event) {
//        Event event1 = new Event();
//        event1.setName(event.getName());
//        event1.setLocation(event.getLocation());

        this.eventService.createEvent(event);

//        if (event.getId() == null) {
//            this.eventService.createEvent(event);
//        } else {
//            this.eventService.updateEvent(event);
//        }
        return "redirect:/events";
    }

    @RequestMapping(value = "/remove")

    public String removeEvent(@RequestParam(value = "eventId", required = false) Long id) {
        System.out.println(id);
        this.eventService.deleteEvent(id);
        return "redirect:/events";

    }


    @RequestMapping(value = "edit/{id}")
    public String editEvent(@PathVariable("id") Long id, Model model) {
        model.addAttribute("event", this.eventService.findByEventId(id));
        model.addAttribute("listEvent", this.eventService.findAllEvent());
        return "events";
    }
}
