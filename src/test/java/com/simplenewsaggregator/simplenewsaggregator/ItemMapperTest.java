package com.simplenewsaggregator.simplenewsaggregator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.mappers.ItemMapper;
import com.simplenewsaggregator.simplenewsaggregator.dtos.ItemDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Story;

@SpringBootTest
public class ItemMapperTest {
    @Test
    void shouldMapItemDtoToStory() {
        ItemDto itemDto = new ItemDto("Foobar", "http://foo.bar", "Lorem ipsum description");

        Story story = ItemMapper.INSTANCE.itemDtoToStory(itemDto);
        assertNotNull(story);
        assertEquals(itemDto.getTitle(), story.getTitle());
        assertEquals(itemDto.getLink(), story.getUrl());
        assertEquals(itemDto.getDescription(), story.getDescription());
    }
}
