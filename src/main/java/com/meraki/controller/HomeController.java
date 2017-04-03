package com.meraki.controller;

import com.meraki.entity.User;
import com.meraki.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private UserService userService;

    private HttpSession response;

    @Autowired
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("httpSession")
    public void setResponse(HttpSession response) {
        this.response = response;
    }



    //====================================== Methods ==============================================

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User user = userService.getUserByUsername(username);
            response.setAttribute("user", user);
        }
        log.info("*** Home Controller *** ||| Welcome home! ||| ");
        return "home";
    }

}
