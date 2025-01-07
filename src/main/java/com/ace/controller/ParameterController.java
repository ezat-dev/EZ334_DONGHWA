package com.ace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParameterController {

    @RequestMapping(value = "/parameter/fastcoolingPop", method = RequestMethod.GET)
    public String fastCoolingPop(Model model) {
        return "/parameter/fastcoolingPop.jsp";
    }

    @RequestMapping(value = "/parameter/limitSwitchesPop", method = RequestMethod.GET)
    public String limitSwitchesPop(Model model) {
        return "/parameter/limitSwitchesPop.jsp";
    }

    @RequestMapping(value = "/parameter/timerPop", method = RequestMethod.GET)
    public String timerPop(Model model) {
        return "/parameter/timerPop.jsp";
    }
}
