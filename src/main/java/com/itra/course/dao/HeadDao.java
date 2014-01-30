package com.itra.course.dao;

import com.itra.course.model.Head;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:34
 */
public interface HeadDao extends GenericDao<Head> {

    public void addHead(Head head);

}
