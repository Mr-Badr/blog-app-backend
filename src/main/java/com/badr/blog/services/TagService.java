package com.badr.blog.services;

import com.badr.blog.domain.entities.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTags();
}
