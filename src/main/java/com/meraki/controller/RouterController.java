package com.meraki.controller;

import com.meraki.entity.Router;
import com.meraki.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Verlamov on 16.03.17.
 */
@Controller
public class RouterController {
    @Autowired
    private RouterService routerService;

    @Autowired
    public void setRouterService(RouterService routerService) {
        this.routerService = routerService;
    }

    @RequestMapping(value = "/router/add", method = RequestMethod.POST)
    public String addRouter(@ModelAttribute("router") Router router) {
        if (router.getRouterId() == 0) {
            //nre router add it
            this.routerService.addRouter(router);
        } else {
            //existing router call update
            this.routerService.updateRouter(router);
        }
        return "redirect:/router" + router.getEventId();
    }

    @RequestMapping(value = "/edit_router/{id}")
    public ModelAndView editRouter(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("router");
        modelAndView.addObject("router", this.routerService.getRouterById(id));
        return modelAndView;
    }


    @RequestMapping(value = "/event{eventId}/remove_router/{routerId")
    public String deleteRouter(@PathVariable("eventId") int eventId, @PathVariable("routerId") int routerId) {
        this.routerService.removeRouter(routerId);
        return "redirect:/router/" + routerId;
    }


}
