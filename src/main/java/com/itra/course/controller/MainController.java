package com.itra.course.controller;

import com.itra.course.model.Creative;
import com.itra.course.service.CreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CreativeService creativeService;

    @RequestMapping(value = "/")
    public ModelAndView home(ModelAndView mav) {
        List<Creative> creatives = creativeService.getCreatives();
        mav.addObject("creatives", creatives);
        mav.setViewName("general/main");
        return mav;
    }

}
