package com.meraki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Verlamov on 23.03.17.
 */
@Controller
public class StoreController {


    @RequestMapping(value = "storeList")
    public String goStore(){
        return "storeList";
    }
}
