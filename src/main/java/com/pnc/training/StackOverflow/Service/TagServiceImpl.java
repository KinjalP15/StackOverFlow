package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.DAO.TagDao;
import com.pnc.training.StackOverflow.Entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;

    @Override
    public void saveTag(Tag tag) {
        tagDao.save(tag);

    }

    @Override
    public int findTagCountByTagName(String tagName) {
        return tagDao.findTagCountByTagName(tagName);
    }

    @Override
    public Tag findByTagName(String tagName) {
        return tagDao.findByTagName(tagName);
    }
}
