package com.badr.blog.services;

import com.badr.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {
    List<Tag> getTags();
    List<Tag> createTags(Set<String> tagNames);
    void deleteTag(UUID id);

    // We use this with Posts filtering
    Tag getTagById(UUID id);
}
