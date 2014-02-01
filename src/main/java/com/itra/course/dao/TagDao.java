package com.itra.course.dao;

import com.itra.course.model.Tag;

/**
 * User: Greenjerk
 * Date: 31.01.14
 * Time: 12:35
 */
public interface TagDao extends GenericDao<Tag, Long> {

    public Tag getTagByName(String tagName);

}
