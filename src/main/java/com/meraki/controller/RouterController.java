package com.meraki.controller;

import com.meraki.model.Router;
import com.meraki.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouterController {

    @Autowired
    private RouterService routerService;

    @Autowired
    public void setRouterService(RouterService routerService) {
        this.routerService = routerService;
    }


    @RequestMapping(value = "routers", method = RequestMethod.GET)
    public String listRouters(Model model) {
        model.addAttribute("router", new Router());
        model.addAttribute("listRouter", this.routerService.findAllRouter());
        return "routers";
    }


}
