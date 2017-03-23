package com.meraki.controller;

import com.meraki.entity.BlackBook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Verlamov on 23.03.17.
 */
@Controller
public class ShopController {


    @RequestMapping(name = "/shopList")
    public String gotoShop() {
        return "shopList";
    }
}
