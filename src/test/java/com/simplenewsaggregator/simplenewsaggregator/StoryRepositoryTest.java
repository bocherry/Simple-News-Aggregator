package com.simplenewsaggregator.simplenewsaggregator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.simplenewsaggregator.models.Story;
import com.simplenewsaggregator.simplenewsaggregator.repositories.StoryRepository;

@SpringBootTest
public class StoryRepositoryTest {
    
    @Autowired
    private StoryRepository storyRepository;

    @Test
    void shouldSaveStory() {
        Story story = new Story();
        story.setTitle("Foo bar title");
        story.setDescription("Lorem ipsum description");
        story.setUrl("https://foo.bar");
        assertDoesNotThrow(() -> storyRepository.save(story));
    }

    @Test
    void shouldRetrieveStoredStory() {
        Story story = new Story();
        story.setTitle("Foo bar title");
        story.setDescription("Lorem ipsum description");
        story.setUrl("https://foo.bar");

        Long id = storyRepository.save(story).getId();
        Story retrievedStory = storyRepository.findById(id).get();

        assertNotNull(retrievedStory);
        assertEquals(story.getTitle(), retrievedStory.getTitle());
        assertEquals(story.getDescription(), retrievedStory.getDescription());
        assertEquals(story.getUrl(), story.getUrl());
    }
}
