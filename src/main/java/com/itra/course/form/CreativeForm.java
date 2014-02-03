package com.itra.course.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 20:52
 */

public class CreativeForm {

    @Size(min = 3, max = 64, message = "{validation.size}")
    @NotEmpty(message = "{validation.not_empty}")
    private String title;

    @Size(min = 3, max = 400, message = "{validation.size}")
    @NotEmpty(message = "{validation.not_empty}")
    private String description;

    @NotNull
    private String tags;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
