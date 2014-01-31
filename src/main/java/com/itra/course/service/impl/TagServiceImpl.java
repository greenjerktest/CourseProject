package com.itra.course.service.impl;

import com.itra.course.dao.TagDao;
import com.itra.course.model.Tag;
import com.itra.course.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Greenjerk
 * Date: 31.01.14
 * Time: 12:43
 */

@Transactional
@Service
public class TagServiceImpl extends GenericManagerImpl<Tag> implements TagService {

    private TagDao tagDao;

    @Autowired
    public TagServiceImpl(TagDao tagDao) {
        super(tagDao);
        this.tagDao = tagDao;
    }

    public List<Tag> searchTag(String query) {

        List<Tag> matched = new ArrayList<>();
        List<Tag> tags = tagDao.getAll();
        for (Tag tag : tags) {
            if (tag.getTagName().toLowerCase().contains(query.toLowerCase())) {
                matched.add(tag);
            }
        }
        return matched;
    }

    @Override
    public List<Tag> getTagList(String tags) {

        List<Tag> tagList = new ArrayList<>();
        String[] tagNameArr = tags.split(",");
        for (int i = 0; i < tagNameArr.length; i++) {
            tagList.add(tagDao.getTagByName(tagNameArr[i]));
        }
        return tagList;
    }

}
