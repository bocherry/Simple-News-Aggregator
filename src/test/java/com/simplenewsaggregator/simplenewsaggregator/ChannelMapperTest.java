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

@SpringBootTest
public class ChannelMapperTest {
    @Test
    void shouldMapChanneltoToPublisher() {
        ArrayList<ItemDto> itemDtos = new ArrayList<ItemDto>();
        itemDtos.add(new ItemDto("Foo bar title", "https://foo.bar", "lorem ispum description"));
        ChannelDto channelDto = new ChannelDto("Publisher title", "https://foo.bar", "Lorem ipsum description", "FO_bar", "hourly", 43, itemDtos);

        Publisher publisher = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto);

        assertNotNull(publisher);
        assertEquals(publisher.getTitle(), channelDto.getTitle());
        assertEquals(publisher.getUrl(), channelDto.getLink());
        assertEquals(publisher.getDescription(), channelDto.getDescription());
        assertEquals(publisher.getLanguage(), channelDto.getLanguage());
    }

    @Test
    void shouldMapChanneltoToPublisherConfiguration() {
        ArrayList<ItemDto> itemDtos = new ArrayList<ItemDto>();
        itemDtos.add(new ItemDto("Foo bar title", "https://foo.bar", "lorem ispum description"));
        ChannelDto channelDto = new ChannelDto("Publisher title", "https://foo.bar", "Lorem ipsum description", "FO_bar", "hourly", 43, itemDtos);

        PublisherConfiguration configuration = ChannelMapper.INSTANCE.channelDtoToPublisherConfiguration(channelDto);
        
        assertNotNull(configuration);
        assertEquals(channelDto.getUpdatePeriod(), configuration.getUpdatePeriod());
        assertEquals(channelDto.getUpdateFrequency(), configuration.getUpdateFrequency());

    }
}
