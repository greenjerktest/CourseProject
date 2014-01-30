package com.itra.course.service;

import com.itra.course.form.CreativeForm;
import com.itra.course.model.Creative;
import com.itra.course.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 19:40
 */
public interface CreativeService extends GenericManager<Creative> {

    public List getCreatives();
    public Creative getCreative(long id);
    public long addCreative(CreativeForm creativeForm, MultipartFile file, User author)
            throws IOException;
    public byte[] getCurrentLogo(Creative creative) throws IOException;

}
