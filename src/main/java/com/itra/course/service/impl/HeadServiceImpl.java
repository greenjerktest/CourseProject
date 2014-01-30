package com.itra.course.service.impl;

import com.itra.course.dao.HeadDao;
import com.itra.course.form.HeadForm;
import com.itra.course.model.Creative;
import com.itra.course.model.Head;
import com.itra.course.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:33
 */

@Transactional
@Service
public class HeadServiceImpl extends GenericManagerImpl<Head> implements HeadService {

    private HeadDao headDao;

    @Autowired
    public HeadServiceImpl(HeadDao headDao) {
        super(headDao);
        this.headDao = headDao;
    }

    @Override
    public void addHead(HeadForm form, Creative creative) {
        Head head = new Head();
        head.setTitle(form.getTitle());
        head.setContent(form.getContent());
        head.setCreative(creative);
        headDao.addHead(head);
    }
}
