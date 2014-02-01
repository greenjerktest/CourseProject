package com.itra.course.service.impl;

import com.itra.course.dao.CommentDao;
import com.itra.course.form.CommentForm;
import com.itra.course.model.Comment;
import com.itra.course.model.Creative;
import com.itra.course.model.User;
import com.itra.course.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 11:44
 */

@Transactional
@Service
public class CommentServiceImpl extends GenericManagerImpl<Comment, Long>
        implements CommentService {


    private CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        super(commentDao);
        this.commentDao = commentDao;
    }

    @Override
    public void addComment(Creative creative, CommentForm commentForm, User author) {

        Comment comment = new Comment();
        comment.setCreative(creative);
        comment.setComment(commentForm.getComment());
        comment.setUser(author);
        commentDao.save(comment);
    }

}
