package com.itra.course.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 11:34
 */
public class CommentForm {

    @Size(min = 1, max = 255, message = "{validation.size}")
    @NotEmpty(message = "{validation.not_empty}")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
