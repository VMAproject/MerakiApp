package com.meraki.controller;

import com.meraki.entity.Router;
import com.meraki.service.interfaces.RouterService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {

    private static final Logger logger = Logger.getLogger(RouterController.class);

    private RouterService routerService;

    @Autowired
    @Qualifier("routerServiceImpl")
    public void setRouterService(RouterService routerService) {
        this.routerService = routerService;
    }

    @RequestMapping("/routers/all")
    public String showRouters(Model model) {
        model.addAttribute("routerList", routerService.getAllRouters());
        return "router/routerList";
    }


    @RequestMapping("createRouter")
    public ModelAndView createRouter(@ModelAttribute Router router) {
        return new ModelAndView("router/routerForm");
    }

    @RequestMapping("editRouter")
    public ModelAndView editRouter(@RequestParam long id, @ModelAttribute Router router) {
        router = routerService.getRouter(id);
        return new ModelAndView("router/routerForm", "routerObject", router);
    }


    @RequestMapping(value = "saveRouter", method = RequestMethod.POST)
    public ModelAndView saveRouter(@ModelAttribute Router router) {
        if (router.getId() == 0) {
            routerService.createRouter(router);
        } else {
            routerService.updateRouter(router);
        }
        return new ModelAndView("redirect:/routers/all");
    }


    @RequestMapping("deleteRouter")
    public ModelAndView deleteRouter(@RequestParam long id) {
        routerService.deleteRouter(id);
        logger.info("*** RouterController *** Delete Router " + id);
        return new ModelAndView("redirect:/routers/all");
    }


}
