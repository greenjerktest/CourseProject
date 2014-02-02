package com.itra.course.dao;

import com.itra.course.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Greenjerk
 * Date: 02.02.14
 * Time: 13:40
 */
public class TagDaoTest extends BaseTestCase {

    @Autowired
    TagDao tagDao;

    @Test
    public void testReindex() {
        tagDao.reindexAll(false);
    }

}
