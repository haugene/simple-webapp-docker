package com.capgemini.no.dockerfun.controller;

import com.capgemini.no.dockerfun.utils.HostnameResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BaseController {


    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        return "index";

    }


    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome to this demo webapp");
        model.addAttribute("serverHostname", new HostnameResolver().getHostname());

        //Spring uses InternalResourceViewResolver and return back welcome.jsp
        return "welcome";

    }

    @RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome " + name + "! This is a demo webapp");
        model.addAttribute("serverHostname", new HostnameResolver().getHostname());

        return "welcome";

    }

}