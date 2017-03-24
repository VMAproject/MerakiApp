package com.meraki.controller;

import com.meraki.service.RouterService;
import com.meraki.service.StoreService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Verlamov on 23.03.17.
 */
@Controller
public class StoreController {

    private static final Logger logger = Logger.getLogger(StoreController.class);

    @Autowired
    private StoreService storeService;

    @Autowired
    private RouterService routerService;

    @RequestMapping("/stores/all")
    public String showStore(Model model) {
        model.addAttribute("allStores", storeService.getAllStore());
        return "storeList";
    }
}
