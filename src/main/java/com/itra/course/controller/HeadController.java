package com.itra.course.controller;

import com.itra.course.form.HeadForm;
import com.itra.course.model.Creative;
import com.itra.course.service.CreativeService;
import com.itra.course.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:40
 */

@Controller
public class HeadController {

    @Autowired
    private HeadService headService;
    @Autowired
    private CreativeService creativeService;

    @RequestMapping(value = "user/creative/{creativeId}/add_head")
    public ModelAndView createHead(
            ModelAndView mav, @PathVariable("creativeId") String creativeId) {
        mav.addObject("headForm", new HeadForm());
        mav.addObject("creativeId", creativeId);
        mav.setViewName("user/create_head");
        return mav;
    }

    @RequestMapping(value = "user/creative/{creativeId}/add_head",
            method = RequestMethod.POST)
    public ModelAndView createHeadPost(
            ModelAndView mav,
            @PathVariable("creativeId") long creativeId,
            @ModelAttribute("headForm") @Valid HeadForm headForm,
            BindingResult result) {

        mav.setViewName("redirect:/user/creative/{creativeId}/add_head");
        if (result.hasErrors()) {
            return mav;
        }

        Creative creative = creativeService.get(creativeId);
        headService.addHead(headForm, creative);
        mav.setViewName("redirect:/general/creative/{creativeId}");
        return mav;
    }

}
