package com.meraki.controller;

import com.meraki.entity.Router;
import com.meraki.entity.Store;
import com.meraki.service.interfaces.RouterService;
import com.meraki.service.interfaces.StoreService;
import com.meraki.statistics.service.interfaces.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StoreController {

    private StoreService storeService;
    private RouterService routerService;
    private StatisticService statisticService;

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

    @Autowired
    @Qualifier("statisticServiceImpl")
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    //====================================== Methods ==============================================


    @RequestMapping("/stores/add")
    public String addStore(Model model) {
        model.addAttribute("routers", routerService.getAllRouters());
        return "store/storeForm";
    }

    @RequestMapping(value = "/stores/edit", method = RequestMethod.GET)
    public String editStore(@RequestParam long id,
                            Model model) {

        Store store = storeService.getStore(id);
        model.addAttribute("storeId", store.getId());
        model.addAttribute("storeName", store.getName());
        model.addAttribute("storeLocation", store.getLocation());
        model.addAttribute("routers", routerService.getAllRouters());

        return "store/storeForm";
    }

    @RequestMapping(value = "/stores/createOrUpdate", method = RequestMethod.GET)
    public String createOrUpdateEvent(@RequestParam String storeId,
                                      @RequestParam String name,
                                      @RequestParam String location,
                                      @RequestParam long routerId) {

        Store store = new Store();
        if (storeId.isEmpty()) {
            store.setName(name);
            store.setLocation(location);
            storeService.createStore(store);

            Router router = routerService.getRouter(routerId);
            router.setStore(store);
            routerService.updateRouter(router);
        } else {
            store.setId(new Long(storeId));
            store.setName(name);
            store.setLocation(location);
            storeService.updateStore(store);

            Router router = routerService.getRouter(routerId);
            router.setStore(store);
            routerService.updateRouter(router);
        }

        return "redirect:/stores/all";
    }

    @RequestMapping("/stores/delete")
    public String deleteEvent(@RequestParam("id") long id) {

        List<Router> routers = statisticService.getRoutersByStoreId(id);
        for (Router router : routers) {
            router.setStore(null);
            routerService.updateRouter(router);
        }

        storeService.deleteStore(id);

        return "redirect:/stores/all";
    }

    @RequestMapping("/stores/all")
    public String showStores(Model model) {
        model.addAttribute("stores", storeService.getAllStore());
        return "store/storeList";
    }

}
