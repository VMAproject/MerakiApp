package com.meraki.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@ControllerAdvice
public class ExceptionController {


    private static final Logger logger = Logger.getLogger(ExceptionController.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundPage() {
        logger.info("*** Exception Controller *** handle Not Found Page ");
        return "redirect:/404";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFoundPage() {
        logger.info("*** Exception Controller *** NOT Found Page");
        return "exception/404";
    }
}
