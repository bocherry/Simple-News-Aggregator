package com.simplenewsaggregator.simplenewsaggregator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplenewsaggregator.simplenewsaggregator.models.Story;

public interface StoryRepository extends CrudRepository<Story, Long>{
    
}
