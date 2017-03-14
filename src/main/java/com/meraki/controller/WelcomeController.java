package com.meraki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {


    @RequestMapping(value = "/events")
    public String goEvent() {
        return "events";
    }


    @RequestMapping(value = "/routers")
    public String goRouter(){
        return "routers";
    }
}
