package com.simplenewsaggregator.simplenewsaggregator.dtos;

public class RssDto {
    private ChannelDto channelDto;

    public ChannelDto getChannelDto() {
        return this.channelDto;
    }

    public void setChannelDto(ChannelDto channelDto) {
        this.channelDto = channelDto;
    }

    @Override
    public String toString() {
        return "{" +
            " channelDto='" + getChannelDto() + "'" +
            "}";
    }

}
