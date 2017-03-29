package com.meraki.controller;

import com.meraki.entity.Router;
import com.meraki.entity.Store;
import com.meraki.service.interfaces.EventService;
import com.meraki.service.interfaces.RouterService;
import com.meraki.service.interfaces.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {

    private StoreService storeService;

    private RouterService routerService;

    @Autowired
    @Qualifier("storeServiceImpl")
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    @Autowired
    @Qualifier("routerServiceImpl")
    public void setRouterService(RouterService routerService) {
        this.routerService = routerService;
    }

    @RequestMapping("/stores/add")
    public String addStore(Model model) {
        model.addAttribute("routers", routerService.getAllRouters());
        return "store/storeForm";
    }

    @RequestMapping(value = "/stores/create", method = RequestMethod.GET)
    public String createStore(@RequestParam String name,
                              @RequestParam String location,
                              @RequestParam long id) {

        Store storeByParam = new Store();
        storeByParam.setName(name);
        storeByParam.setLocation(location);

        long storeId = storeService.createStore(storeByParam);

        storeByParam.setId(storeId);
        Router loadedRouter = routerService.getRouter(id);
        loadedRouter.setStore(storeByParam);
        routerService.updateRouter(loadedRouter);
        return "redirect:/stores/all";
    }

    @RequestMapping("/stores/all")
    public String showStores(Model model) {
        model.addAttribute("stores", storeService.getAllStore());
        return "store/storeList";
    }

}
