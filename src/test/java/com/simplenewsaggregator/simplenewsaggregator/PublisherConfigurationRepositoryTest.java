package com.simplenewsaggregator.simplenewsaggregator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.simplenewsaggregator.models.PublisherConfiguration;
import com.simplenewsaggregator.simplenewsaggregator.repositories.PublisherConfigurationRepository;

@SpringBootTest
public class PublisherConfigurationRepositoryTest {
    
    @Autowired
    private PublisherConfigurationRepository repository;

    @Test
    void shouldSaveAndRetrievePublisherConfigurationEntity() {
        PublisherConfiguration configuration = new PublisherConfiguration();
        configuration.setRssUrl("https://foo.bar/rss");
        configuration.setUpdateFrequency(2);
        configuration.setUpdatePeriod("yearly");

        assertDoesNotThrow(() -> repository.save(configuration));
        Long id = repository.save(configuration).getId();

        PublisherConfiguration retrievedConfiguration = repository.findById(id).get();

        assertNotNull(retrievedConfiguration);
        assertEquals(configuration.getRssUrl(), retrievedConfiguration.getRssUrl());
        assertEquals(configuration.getUpdateFrequency(), retrievedConfiguration.getUpdateFrequency());
        assertEquals(configuration.getUpdatePeriod(), retrievedConfiguration.getUpdatePeriod());
    }

}
