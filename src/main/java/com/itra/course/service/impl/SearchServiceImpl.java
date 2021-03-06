package com.itra.course.service.impl;

import com.itra.course.model.Comment;
import com.itra.course.model.Creative;
import com.itra.course.model.Head;
import com.itra.course.model.Tag;
import com.itra.course.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Greenjerk
 * Date: 30.01.14
 * Time: 15:32
 */

@Transactional
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    CommentService commentService;
    @Autowired
    CreativeService creativeService;
    @Autowired
    HeadService headService;
    @Autowired
    TagService tagService;

    @Override
    public Set<Creative> search(String term) {
        Set<Creative> creativeSet = new HashSet<Creative>();

        for (Comment comment : commentService.search(term)) {
            creativeSet.add(comment.getCreative());
        }

        for (Head head : headService.search(term)) {
            creativeSet.add(head.getCreative());
        }

        for (Tag tag : tagService.search(term)) {
            creativeSet.addAll(tag.getCreatives());
        }

        for (Creative creative : creativeService.search(term)) {
            creativeSet.add(creative);
        }

        return creativeSet;
    }
}
