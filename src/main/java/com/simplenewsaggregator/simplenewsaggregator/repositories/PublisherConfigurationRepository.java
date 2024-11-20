package com.simplenewsaggregator.simplenewsaggregator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simplenewsaggregator.simplenewsaggregator.models.PublisherConfiguration;

public interface PublisherConfigurationRepository extends CrudRepository<PublisherConfiguration, Long>{
    PublisherConfiguration findByPublisherId(Long id);
}
