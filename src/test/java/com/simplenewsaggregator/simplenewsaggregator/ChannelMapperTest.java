package com.simplenewsaggregator.simplenewsaggregator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.mappers.ChannelMapper;
import com.simplenewsaggregator.simplenewsaggregator.dtos.ChannelDto;
import com.simplenewsaggregator.simplenewsaggregator.dtos.ItemDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Publisher;
import com.simplenewsaggregator.simplenewsaggregator.models.PublisherConfiguration;
import com.simplenewsaggregator.simplenewsaggregator.models.Story;

@SpringBootTest
public class ChannelMapperTest {
    @Test
    void shouldMapChanneltoToPublisher() {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        ChannelDto channelDto = new ChannelDto("Publisher title", "https://foo.bar", "Lorem ipsum description", "FO_bar", "hourly", 43, itemDtos);

        Publisher publisher = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto, "https://foo.bar/feed");

        assertNotNull(publisher);
        assertEquals(publisher.getTitle(), channelDto.getTitle());
        assertEquals(publisher.getUrl(), channelDto.getLink());
        assertEquals(publisher.getDescription(), channelDto.getDescription());
        assertEquals(publisher.getLanguage(), channelDto.getLanguage());
    }

    @Test
    void shouldMapChanneltoToPublisherConfiguration() {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        ChannelDto channelDto = new ChannelDto("Publisher title", "https://foo.bar", "Lorem ipsum description", "FO_bar", "hourly", 43, itemDtos);

        PublisherConfiguration configuration = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto, "https://foo.bar/feed").getConfiguration();
        
        assertNotNull(configuration);
        System.out.println(configuration);
        assertEquals(channelDto.getUpdatePeriod(), configuration.getUpdatePeriod());
        assertEquals(channelDto.getUpdateFrequency(), configuration.getUpdateFrequency());

    }

    @Test
    void shouldMapItemsListToStoriesList() {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        ItemDto itemDto = new ItemDto("Foo bar title", "https://foo.bar", "lorem ispum description");
        itemDtos.add(itemDto);
        ChannelDto channelDto = new ChannelDto("Publisher title", "https://foo.bar", "Lorem ipsum description", "FO_bar", "hourly", 43, itemDtos);

        Publisher publisher = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto, "https://foo.bar/feed");

        Story story = publisher.getStories().get(0);

        assertNotNull(story);
        assertEquals(itemDto.getTitle(), story.getTitle());
        assertEquals(itemDto.getLink(), story.getUrl());
        assertEquals(itemDto.getDescription(), story.getDescription());
    }
}
