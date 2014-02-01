package com.itra.course.controller;

import com.itra.course.form.CommentForm;
import com.itra.course.form.CreativeForm;
import com.itra.course.model.Creative;
import com.itra.course.model.User;
import com.itra.course.service.CommentService;
import com.itra.course.service.CreativeService;
import com.itra.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

/**
 * User: Greenjerk
 * Date: 26.01.14
 * Time: 11:37
 */

@Controller
public class CreativeController {

    @Autowired
    private CreativeService creativeService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "general/creative/{creativeId}")
    public ModelAndView creative(ModelAndView mav,
                                 @PathVariable long creativeId) {
        Creative creative = creativeService.get(creativeId);
        mav.addObject("creative", creative);
        mav.addObject("commentForm", new CommentForm());
        mav.setViewName("general/creative");
        return mav;
    }

    @RequestMapping(value = "general/creative/{creativeId}/add_comment", method = RequestMethod.POST)
    public ModelAndView addCommentPost(
            ModelAndView mav,
            @ModelAttribute("commentForm") @Valid CommentForm commentForm,
            BindingResult result,
            Principal principal,
            @PathVariable("creativeId") long creativeId) {

        mav.setViewName("redirect:/general/creative/{creativeId}");
        if (result.hasErrors()) {
            return mav;
        }

        Creative creative = creativeService.get(creativeId);
        User author = userService.getUserByName(principal.getName());
        commentService.addComment(creative, commentForm, author);
        return mav;
    }

    @RequestMapping(value = "general/creative/{creativeId}/remove_comment",
            method = RequestMethod.POST)
    public ModelAndView deleteComment(ModelAndView mav,
                                      @RequestParam long commentId,
                                      @PathVariable("creativeId") String creativeId) {
        commentService.remove(commentId);
        mav.setViewName("redirect:/general/creative/{creativeId}");
        return mav;
    }

    @RequestMapping(value = "user/creative/new")
    public ModelAndView createCreative(ModelAndView mav) {
        mav.addObject("creativeForm", new CreativeForm());
        mav.setViewName("user/create_creative");
        return mav;
    }

    @RequestMapping(value = "user/creative/new", method = RequestMethod.POST)
    public ModelAndView createCreativePost(
            ModelAndView mav,
            Principal principal,
            @RequestParam("logo") MultipartFile logo,
            @ModelAttribute("creativeForm") @Valid CreativeForm creativeForm,
            BindingResult result) throws IOException {

        mav.setViewName("redirect:/user/creative/new");

        if (result.hasErrors()) {
            return mav;
        }

        User author = userService.getUserByName(principal.getName());
        long id = creativeService.addCreative(creativeForm, logo, author);

        mav.setViewName("redirect:/general/creative/" + id);
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "general/{creativeId}/logo",
            method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] useAvatar(@PathVariable("creativeId") long creativeId)
            throws IOException {
        Creative creative = creativeService.get(creativeId);
        return creativeService.getCurrentLogo(creative);
    }

}
