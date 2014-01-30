package com.itra.course.form;

import javax.validation.constraints.Size;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 20:52
 */
public class CreativeForm {

    @Size(min = 3, max = 64)
    private String title;

    @Size(min = 3, max = 400)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
