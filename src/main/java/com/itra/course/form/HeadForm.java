package com.itra.course.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:28
 */
public class HeadForm {

    @Size(min = 3, max = 255, message = "{validation.size}")
    @NotEmpty(message = "{validation.not_empty}")
    private String title;

    @NotEmpty(message = "{validation.not_empty}")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
