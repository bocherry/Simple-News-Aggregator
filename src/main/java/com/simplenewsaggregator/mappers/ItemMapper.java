package com.simplenewsaggregator.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.simplenewsaggregator.simplenewsaggregator.dtos.ItemDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Story;

@Mapper
public interface ItemMapper {
    
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(target = "url", source= "link")
    Story itemDtoToStory(ItemDto itemDto);
}
