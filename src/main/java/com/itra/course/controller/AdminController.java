package com.itra.course.controller;

import com.itra.course.model.User;
import com.itra.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin")
    public ModelAndView admin(ModelAndView mav, Principal principal) {
        List<User> users = userService.getSimpleUsers();
        mav.addObject("users", users);
        mav.setViewName("admin/administrator");
        return mav;
    }

    @RequestMapping(value = "admin/delete_user", method = RequestMethod.POST)
    public ModelAndView deletePost(ModelAndView mav, @RequestParam String username) {
        userService.removeUser(username);
        mav.setViewName("redirect:/admin");
        return mav;
    }

    @RequestMapping(value = "admin/block_user", method = RequestMethod.POST)
    public ModelAndView blockPost(ModelAndView mav, @RequestParam String username) {
        userService.blockUser(username);
        mav.setViewName("redirect:/admin");
        return mav;
    }

}