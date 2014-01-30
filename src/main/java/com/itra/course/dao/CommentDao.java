package com.itra.course.dao;

import com.itra.course.model.Comment;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 11:39
 */
public interface CommentDao extends GenericDao<Comment> {

    public void addComment(Comment comment);
    public void removeComment(long id);

}
