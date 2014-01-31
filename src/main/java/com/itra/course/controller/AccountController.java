package com.itra.course.controller;

import com.itra.course.form.RegisterForm;
import com.itra.course.form.UserForm;
import com.itra.course.model.User;
import com.itra.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Locale;

@Controller
public class AccountController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "anonymous/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "anonymous/login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "anonymous/login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "anonymous/login";
    }

    @RequestMapping(value = "anonymous/register")
    public ModelAndView register(ModelAndView mav) {
        mav.addObject("registerForm", new RegisterForm());
        mav.setViewName("anonymous/register");
        return mav;
    }

    @RequestMapping(value = "anonymous/register", method = RequestMethod.POST)
    public ModelAndView registerPost(
            ModelAndView mav,
            Locale locale,
            @ModelAttribute("registerForm") @Valid RegisterForm r,
            BindingResult result) {

        if (!r.getPassword().equals(r.getConfirmPassword())) {

            result.addError(new FieldError("registerForm", "password",
                    messageSource.getMessage("validation.different_pass", null, locale)));
        }

        if ((userService.getUserByName(r.getUsername())) != null) {
            result.addError(new FieldError("registerForm", "username",
                    messageSource.getMessage("validation.duplicate_name", null, locale)));
        }

        if (result.hasErrors()) {
            mav.setViewName("anonymous/register");
            return mav;
        }

        userService.addUser(r);
        mav.setViewName("redirect:/anonymous/login");
        return mav;
    }

    @RequestMapping(value = "user/profile")
    public ModelAndView profile(ModelAndView mav) {
        mav.addObject("userForm", new UserForm());
        mav.setViewName("user/profile");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "user/profile/avatar", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] avatarUploadForm(Principal principal) throws IOException {
        User user = userService.getUserByName(principal.getName());
        return userService.getCurrentAvatar(user);
    }

    @ResponseBody
    @RequestMapping(value = "general/{commentUserUsername}/avatar",
            method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] useAvatar(@PathVariable("commentUserUsername") String commentUserUsername)
            throws IOException {
        User user = userService.getUserByName(commentUserUsername);
        return userService.getCurrentAvatar(user);
    }

    @RequestMapping(value = "user/profile/avatar", method = RequestMethod.POST)
    public ModelAndView avatarUpload(
            Principal principal,
            @RequestParam("file") MultipartFile file,
            ModelAndView mav) throws IOException {

        User user = userService.getUserByName(principal.getName());
        userService.setAvatarRef(user, file);
        mav.setViewName("redirect:/user/profile");
        return mav;
    }

    @RequestMapping(value = "user/profile", method = RequestMethod.POST)
    public ModelAndView profilePost(
            ModelAndView mav,
            Locale locale,
            Principal principal,
            @ModelAttribute("userForm") @Valid UserForm form,
            BindingResult result) {

        if (!form.getPassword().equals(form.getConfirmPassword())) {
            result.addError(new FieldError("registerForm", "username",
                    messageSource.getMessage("validation.different_pass", null, locale)));
        }

        if (result.hasErrors()) {
            mav.setViewName("user/profile");
            return mav;
        }

        User user = userService.getUserByName(principal.getName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        userService.updateUser(user);
        mav.setViewName("redirect:/");
        return mav;
    }
}