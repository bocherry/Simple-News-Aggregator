package com.simplenewsaggregator.simplenewsaggregator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplenewsaggregator.simplenewsaggregator.models.Story;
import java.util.List;


public interface StoryRepository extends CrudRepository<Story, Long>{
    List<Story> findByPublisherId(Long id);
}
