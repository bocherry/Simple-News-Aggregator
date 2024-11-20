package com.simplenewsaggregator.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.simplenewsaggregator.simplenewsaggregator.dtos.ChannelDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Publisher;

@Mapper(uses=ItemMapper.class)
public interface ChannelMapper {
    
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);
    
    @Mapping(target = "url", source = "rssDto.link")
    @Mapping(target = "stories", source = "rssDto.items")
    @Mapping(target = "configuration.rssUrl", source = "urlString")
    @Mapping(target = "configuration.updatePeriod", source = "rssDto.updatePeriod")
    @Mapping(target = "configuration.updateFrequency", source = "rssDto.updateFrequency")
    Publisher channelDtoToPublisher(ChannelDto rssDto, String urlString);

    @AfterMapping
    default void channelToDtoPostMapping(ChannelDto source, @MappingTarget Publisher publisher) {
        publisher.getConfiguration().setPublisher(publisher);
        publisher.getConfiguration().setUpdatePeriod(publisher.getConfiguration().getUpdatePeriod().trim());
        publisher.getStories().forEach((story) -> story.setPublisher(publisher));
    }

}
