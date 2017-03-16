package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.EventService;
import com.meraki.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by Verlamov on 16.03.17.
 */

@Controller
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private RouterService routerService;

    @Autowired
    private MessageSource messageSource;

    /**
     * This method will list all existing EVENTS.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEvents(Model model) {
        List<Event> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        System.out.println(model);
        System.out.println(events);
        return "eventList";
    }

    /**
     * This method will provide the medium to add a new EVENT.
     */

    @RequestMapping(value = "/newevent", method = RequestMethod.POST)
    public String newEvent(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("edit", false);
        return "eventAdd";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving  event in database. It also validates the event input
     */


    @RequestMapping(value = "/newevent", method = RequestMethod.POST)
    public String saveEvent(@Valid Event event,
                            BindingResult bindingResult,
                            ModelMap modelMap) {

        if (bindingResult.hasErrors()) {
            return "eventAdd";
        }
        if (!eventService.isEventNameUnique(event.getId(), event.getName())) {
            FieldError fieldError = new FieldError("event", "name", messageSource.getMessage("non.unique.name", new String[]{event.getName()}, Locale.getDefault()));
            bindingResult.addError(fieldError);
        }
        eventService.saveEvent(event);

        modelMap.addAttribute("success", "Event" + event.getLocation() + " registered successfully");
        return "eventSuccess";

    }

    /**
     * This method will provide the medium to update an existing event.
     */

    @RequestMapping(value = {"/edit-event-{name}"}, method = RequestMethod.GET)
    public String editEvent(@PathVariable String name, ModelMap modelMap) {

        Event event = eventService.findByName(name);

        modelMap.addAttribute("event", event);
        modelMap.addAttribute("edit", true);

        return "eventAdd";

    }

    @RequestMapping(value = "/edit-event-{name}", method = RequestMethod.POST)
    public String updateEvent(@Valid Event event,
                              BindingResult result,
                              ModelMap model,
                              @PathVariable String name) {

        if (result.hasErrors()) {
            return "eventAdd";
        }
        eventService.updateEvent(event);

        model.addAttribute("success", "Event" + event.getLocation() + "");
        return "eventSuccess";
    }

    /**
     * This method will delete an event by it's NAME value.
     */

    @RequestMapping(value = "/delete-event-{name}", method = RequestMethod.GET)
    public String deleteEvent(@PathVariable String name) {
        eventService.deleteEventByName(name);
        return "redirect:/list";
    }

    /**
     * This method will provide ROUTER list to views
     */
    @ModelAttribute("router")
    public List<Router> initializeRouters() {
        return routerService.findAll();
    }
}
