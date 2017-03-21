package com.meraki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Verlamov on 21.03.17.
 */

@Controller
public class Statistic {

    @RequestMapping("/statistic")
    public String goToStatistic(){
        return "statistic";
    }



}
