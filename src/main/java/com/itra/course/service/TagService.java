package com.itra.course.service;

import com.itra.course.model.Tag;

import java.util.List;
import java.util.Set;

/**
 * User: Greenjerk
 * Date: 31.01.14
 * Time: 12:43
 */
public interface TagService extends GenericManager<Tag, Long> {

    public List<Tag> searchTag(String query);

    public Set<Tag> getTagSet(String tags);

}
