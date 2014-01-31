package com.itra.course.service;

import com.itra.course.model.Tag;

import java.util.List;

/**
 * User: Greenjerk
 * Date: 31.01.14
 * Time: 12:43
 */
public interface TagService extends GenericManager<Tag> {

    public List<Tag> searchTag(String query);

    public List<Tag> getTagList(String tags);

}
