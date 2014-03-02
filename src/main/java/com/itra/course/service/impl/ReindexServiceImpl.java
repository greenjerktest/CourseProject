package com.itra.course.service.impl;

import com.itra.course.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * User: Greenjerk
 * Date: 24.02.14
 * Time: 11:15
 */

@Service
public class ReindexServiceImpl implements ReindexService {

    @Autowired
    CommentService commentService;
    @Autowired
    CreativeService creativeService;
    @Autowired
    HeadService headService;
    @Autowired
    TagService tagService;

    @Override
    @Scheduled(fixedRate=600000)
    public void reindexAll() {
        creativeService.reindexAll(true);
    }

}
