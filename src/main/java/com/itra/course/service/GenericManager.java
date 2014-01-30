package com.itra.course.service;

import java.util.List;

public interface GenericManager<T> {

    List<T> getAll();

    List<T> search(String searchTerm);

    void reindex();

    void reindexAll(boolean async);

}
