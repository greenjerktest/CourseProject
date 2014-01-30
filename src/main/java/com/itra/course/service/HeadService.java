package com.itra.course.service;

import com.itra.course.form.HeadForm;
import com.itra.course.model.Creative;
import com.itra.course.model.Head;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:31
 */

public interface HeadService extends GenericManager<Head> {

    public void addHead(HeadForm form, Creative creative);

}
