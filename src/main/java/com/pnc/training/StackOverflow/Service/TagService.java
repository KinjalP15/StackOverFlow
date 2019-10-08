package com.pnc.training.StackOverflow.Service;

import com.pnc.training.StackOverflow.Entity.Tag;

public interface TagService {

    public void saveTag(Tag tag);

    int findTagCountByTagName(String tagName);

    public Tag findByTagName(String tagName);


}
