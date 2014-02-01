package com.itra.course.dao;

import com.itra.course.model.Creative;

import java.util.List;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 19:55
 */
public interface CreativeDao extends GenericDao<Creative, Long> {

    public List<Creative> getAll();

    public long addCreative(Creative creative);
}
