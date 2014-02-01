package com.itra.course.service;

import com.itra.course.form.CommentForm;
import com.itra.course.model.Comment;
import com.itra.course.model.Creative;
import com.itra.course.model.User;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 11:44
 */
public interface CommentService extends GenericManager<Comment, Long> {

    public void addComment(Creative creative, CommentForm commentForm, User author);

}
