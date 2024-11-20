package com.simplenewsaggregator.simplenewsaggregator.controllers;

import org.jibx.runtime.JiBXException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController
public class RSSController {
    
    private final RestTemplate restTemplate;

    private final XMLUnmarshalService xmlUnmarshalService;

    private final PublisherRepository publisherRepository;

    private final PublisherConfigurationRepository publisherConfigurationRepository;

    private final StoryRepository storyRepository;
    

    @GetMapping("/rss")
    public ResponseEntity addRSS(@RequestParam(value="url") String urlString) throws RestClientException, JiBXException {
        String rss = restTemplate.getForObject(urlString, String.class);

        ChannelDto channelDto = xmlUnmarshalService.unmarshalRssDto(rss).getChannelDto();

        Publisher publisher = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto, urlString);

        publisherRepository.save(publisher);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
