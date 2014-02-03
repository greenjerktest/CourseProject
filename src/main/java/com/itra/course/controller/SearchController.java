package com.itra.course.controller;

import com.itra.course.model.Tag;
import com.itra.course.service.SearchService;
import com.itra.course.service.TagService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: Greenjerk
 * Date: 30.01.14
 * Time: 14:12
 */

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "search")
    public ModelAndView search(ModelAndView mav,
                               HttpServletRequest request) {
        String term = (String) request.getSession().getAttribute("searchTermVariable");
        mav.addObject("creativeList", searchService.search(term));
        mav.setViewName("general/search");
        return mav;
    }

    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public ModelAndView searchPost(
            ModelAndView mav,
            HttpServletRequest request,
            @RequestParam("term") @NotEmpty String term,
            BindingResult result) {

        if (result.hasErrors()) {
            mav.setViewName("redirect:/");
            return mav;
        }

        request.getSession().setAttribute("searchTermVariable", term);
        mav.addObject("creativeList", searchService.search(term));
        mav.setViewName("general/search");
        return mav;
    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Tag> getTags(@RequestParam String query) {

        List<Tag> tagList = tagService.searchTag(query);
        return  tagList;
    }

}
