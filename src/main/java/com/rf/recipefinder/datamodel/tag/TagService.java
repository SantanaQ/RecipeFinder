package com.rf.recipefinder.datamodel.tag;

import com.rf.recipefinder.util.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag saveTag(Tag tag) {
        tag.setName(StringFormatter.trimAndCapitalizeFirstLetter(tag.getName()));
        return tagRepository.findByName(tag.getName())
                .orElseGet(() -> tagRepository.save(tag));
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

}
