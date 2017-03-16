package com.meraki.controller;

import com.meraki.entity.Event;
import com.meraki.entity.Router;
import com.meraki.service.EventService;
import com.meraki.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private RouterService routerService;





}
