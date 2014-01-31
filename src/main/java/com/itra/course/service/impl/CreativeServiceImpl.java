package com.itra.course.service.impl;

import com.itra.course.dao.CreativeDao;
import com.itra.course.form.CreativeForm;
import com.itra.course.model.Creative;
import com.itra.course.model.User;
import com.itra.course.service.CreativeService;
import com.itra.course.service.TagService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Set;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 19:52
 */

@Transactional
@Service
public class CreativeServiceImpl extends GenericManagerImpl<Creative>
        implements CreativeService {

    private CreativeDao creativeDao;

    @Autowired
    private TagService tagService;

    @Autowired
    public CreativeServiceImpl(CreativeDao creativeDao) {
        super(creativeDao);
        this.creativeDao = creativeDao;
    }


    @Override
    public Set getCreatives() {
        return creativeDao.getCreatives();
    }

    @Override
    public Creative getCreative(long id) {
        return creativeDao.getCreative(id);
    }

    @Override
    public long addCreative(CreativeForm creativeForm, MultipartFile logo, User author)
            throws IOException {
        Creative creative = new Creative();
        creative.setAuthor(author);
        creative.setDescription(creativeForm.getDescription());
        creative.setTitle(creativeForm.getTitle());
        creative.setTags(tagService.getTagList(creativeForm.getTags()));

        if (!logo.isEmpty()) {
            String path = System.getProperty("user.home") + "/creative_logo/"
                    + author.getUsername();
            File file = new File(path);
            if (file.mkdirs() || file.exists()) {
                File f = new File(path + "/" + logo.getOriginalFilename());
                OutputStream output = new FileOutputStream(f);
                output.write(IOUtils.toByteArray(logo.getInputStream()));
                output.flush();
                output.close();
                creative.setLogoRef(f.getAbsolutePath());
            }
        }


        long id = creativeDao.addCreative(creative);
        return id;
    }

    @Override
    public byte[] getCurrentLogo(Creative creative) throws IOException {
        if (creative.getLogoRef() == null) {
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("image/default-no-image.png");

            return IOUtils.toByteArray(in);
        }

        InputStream in = new FileInputStream(creative.getLogoRef());
        return IOUtils.toByteArray(in);
    }
}
