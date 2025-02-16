package com.rf.recipefinder.datamodel.tag;

import com.rf.recipefinder.util.Capitalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag saveTag(Tag tag) {
        tag.setName(Capitalizer.capitalizeFirstLetter(tag.getName()));
        Optional<Tag> optionalTag = tagRepository.findByName(tag.getName());
        return optionalTag.orElseGet(() -> tagRepository.save(tag));
    }

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

}
