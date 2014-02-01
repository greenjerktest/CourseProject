package com.itra.course.dao.hibernate;

import com.itra.course.dao.HeadDao;
import com.itra.course.model.Head;
import org.springframework.stereotype.Repository;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:35
 */

@Repository
public class HeadDaoImpl extends GenericDaoImpl<Head, Long> implements HeadDao {

    public HeadDaoImpl() {
        super(Head.class);
    }

}
