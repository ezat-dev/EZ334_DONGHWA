package com.ace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProcessController {

    @RequestMapping(value = "/process/heaterPop", method = RequestMethod.GET)
    public String heaterPop(Model model) {
        return "/process/heaterPop.jsp";
    }

    @RequestMapping(value = "/process/powerConsumptionPop", method = RequestMethod.GET)
    public String powerConsumptionPop(Model model) {
        return "/process/powerConsumptionPop.jsp";
    }

    @RequestMapping(value = "/process/pressPop", method = RequestMethod.GET)
    public String pressPop(Model model) {
        return "/process/pressPop.jsp";
    }

    @RequestMapping(value = "/process/pressurePop", method = RequestMethod.GET)
    public String pressurePop(Model model) {
        return "/process/pressurePop.jsp";
    }

    @RequestMapping(value = "/process/pressureSwitchesPop", method = RequestMethod.GET)
    public String pressureSwitchesPop(Model model) {
        return "/process/pressureSwitchesPop.jsp";
    }

    @RequestMapping(value = "/process/temperaturePop", method = RequestMethod.GET)
    public String temperaturePop(Model model) {
        return "/process/temperaturePop.jsp";
    }
}
