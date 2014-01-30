package com.itra.course.service;

import com.itra.course.model.Creative;

import java.util.Set;

/**
 * User: Greenjerk
 * Date: 30.01.14
 * Time: 15:28
 */

public interface SearchService {

    public Set<Creative> search(String term);

}
