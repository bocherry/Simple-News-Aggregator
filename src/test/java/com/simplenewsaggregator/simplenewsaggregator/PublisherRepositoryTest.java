package com.simplenewsaggregator.simplenewsaggregator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.simplenewsaggregator.models.Publisher;
import com.simplenewsaggregator.simplenewsaggregator.models.PublisherConfiguration;
import com.simplenewsaggregator.simplenewsaggregator.models.Story;
import com.simplenewsaggregator.simplenewsaggregator.repositories.PublisherConfigurationRepository;
import com.simplenewsaggregator.simplenewsaggregator.repositories.PublisherRepository;
import com.simplenewsaggregator.simplenewsaggregator.repositories.StoryRepository;

@SpringBootTest
public class PublisherRepositoryTest {
    
    @Autowired
    private PublisherRepository repository;

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private PublisherConfigurationRepository configurationRepository;

    @Test
    void shouldSaveAndRetrieveUnpopulatedPublisher() {
        Publisher publisher = new Publisher();
        publisher.setLanguage("FR-fr");
        publisher.setDescription("Beautiful and lengthy description");
        publisher.setTitle("Wonderful catchy title");
        publisher.setUrl("https://foo.bar");

        assertDoesNotThrow(() -> repository.save(publisher));
        Long id = repository.save(publisher).getId();
        Publisher retrievedPublisher = repository.findById(id).get();
        assertEquals(publisher.getLanguage(), retrievedPublisher.getLanguage());
        assertEquals(publisher.getDescription(), retrievedPublisher.getDescription());
        assertEquals(publisher.getTitle(), retrievedPublisher.getTitle());
        assertEquals(publisher.getUrl(), retrievedPublisher.getUrl());
    }

    @Test
    void shouldSaveAndRetrievePopulatedPublisher() {
        Publisher publisher = new Publisher();
        publisher.setLanguage("FR-fr");
        publisher.setDescription("Beautiful and lengthy description");
        publisher.setTitle("Wonderful catchy title");
        publisher.setUrl("https://foo.bar");

        // Both could be replaced with mocks, has to enquiry how to
        PublisherConfiguration configuration = new PublisherConfiguration();
        configuration.setRssUrl("https://foo.bar/feed");
        configuration.setUpdateFrequency(3);
        configuration.setUpdatePeriod("yearly");
        publisher.setConfiguration(configuration);

        List<Story> stories = new ArrayList<>();
        Story storyA = new Story();
        storyA.setTitle("Title A");
        storyA.setDescription("lorem ipsum coucou");
        storyA.setUrl("https://foo.bar");
        stories.add(storyA);

        Story storyB = new Story();
        storyB.setTitle("Title B");
        storyB.setDescription("Description B");
        storyB.setUrl("https://foo.bare");
        stories.add(storyB);

        publisher.setStories(stories);

        assertDoesNotThrow(() -> {
            configurationRepository.save(configuration);
            storyRepository.saveAll(stories);
            repository.save(publisher);
        } );
        Long id = repository.save(publisher).getId();
        Publisher retrievedPublisher = repository.findById(id).get();
        assertEquals(publisher.getLanguage(), retrievedPublisher.getLanguage());
        assertEquals(publisher.getDescription(), retrievedPublisher.getDescription());
        assertEquals(publisher.getTitle(), retrievedPublisher.getTitle());
        assertEquals(publisher.getUrl(), retrievedPublisher.getUrl());

        
    }
}
