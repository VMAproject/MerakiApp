package com.meraki.controller;

import com.meraki.entity.Router;
import com.meraki.service.interfaces.RouterService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RouterController {

    private static final Logger logger = org.jboss.logging.Logger.getLogger(RouterController.class);

    @Autowired
    private RouterService routerService;


//    @RequestMapping("getAllRouterLists")
//    public ModelAndView getAllRouters() {
//        List<Router> routerList = routerService.getAllRouters();
//        logger.info("get all router" + routerList);
//        return new ModelAndView("routerList", "routerList", routerList);
//    }


    @RequestMapping("/routers/all")
    public String showRouters(Model model) {
        model.addAttribute("routerList", routerService.getAllRouters());
        return "routerList";
    }

    @RequestMapping("createRouter")
    public ModelAndView createRouter(@ModelAttribute Router router) {
        logger.info("create router" + router);
        return new ModelAndView("routerForm");
    }

    @RequestMapping("editRouter")
    public ModelAndView editRouter(@RequestParam long id, @ModelAttribute Router router) {
        router = routerService.getRouter(id);
        logger.info("edit router" + router);
        return new ModelAndView("routerForm", "routerObject", router);
    }


    @RequestMapping(value = "saveRouter", method = RequestMethod.POST)
    public ModelAndView saveRouter(@ModelAttribute Router router) {
        logger.info("save router" + router);

        if (router.getId() == 0) {
            routerService.createRouter(router);
        } else {
            routerService.updateRouter(router);
        }

        logger.info("save " + router);

        return new ModelAndView("redirect:/routers/all");
    }


    @RequestMapping("deleteRouter")
    public ModelAndView deleteRouter(@RequestParam long id) {
        routerService.deleteRouter(id);
        logger.info("delete router " + id);

        return new ModelAndView("redirect:/routers/all");
    }


}
