package com.simplenewsaggregator.simplenewsaggregator.controllers;

import org.jibx.runtime.JiBXException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.simplenewsaggregator.mappers.ChannelMapper;
import com.simplenewsaggregator.simplenewsaggregator.dtos.ChannelDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Publisher;
import com.simplenewsaggregator.simplenewsaggregator.models.PublisherConfiguration;
import com.simplenewsaggregator.simplenewsaggregator.repositories.PublisherConfigurationRepository;
import com.simplenewsaggregator.simplenewsaggregator.repositories.PublisherRepository;
import com.simplenewsaggregator.simplenewsaggregator.repositories.StoryRepository;
import com.simplenewsaggregator.simplenewsaggregator.services.XMLUnmarshalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RSSController {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private XMLUnmarshalService xmlUnmarshalService;

    @Autowired 
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherConfigurationRepository publisherConfigurationRepository;

    @Autowired
    private StoryRepository storyRepository;
    

    @GetMapping("/rss")
    public void addRSS(@RequestParam(value="url") String param) throws RestClientException, JiBXException {
        String rss = restTemplate.getForObject(param, String.class);

        ChannelDto channelDto = xmlUnmarshalService.unmarshalRssDto(rss).getChannelDto();

        Publisher publisher = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto);
        PublisherConfiguration publisherConfiguration = ChannelMapper.INSTANCE.channelDtoToPublisherConfiguration(channelDto);
        publisherConfiguration.setRSSUrl(param);
        publisher.setConfiguration(publisherConfiguration);
        
        publisherConfigurationRepository.save(publisherConfiguration);
        storyRepository.saveAll(publisher.getStories());
        publisherRepository.save(publisher);
    }
}
