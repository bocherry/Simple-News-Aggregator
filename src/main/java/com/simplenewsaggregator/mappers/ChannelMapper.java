package com.simplenewsaggregator.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.simplenewsaggregator.simplenewsaggregator.dtos.ChannelDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Publisher;
import com.simplenewsaggregator.simplenewsaggregator.models.PublisherConfiguration;

@Mapper
public interface ChannelMapper {
    
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    @Mapping(target = "url", source = "link")
    Publisher rssDtoToPublisher(ChannelDto rssDto);

    PublisherConfiguration rssDtoToPublisherConfiguration(ChannelDto rssDto);
}
