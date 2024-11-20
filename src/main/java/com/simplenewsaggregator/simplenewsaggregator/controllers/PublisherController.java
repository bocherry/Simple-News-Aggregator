package com.simplenewsaggregator.simplenewsaggregator.controllers;

import java.util.List;

import org.jibx.runtime.JiBXException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.simplenewsaggregator.mappers.ChannelMapper;
import com.simplenewsaggregator.simplenewsaggregator.dtos.ChannelDto;
import com.simplenewsaggregator.simplenewsaggregator.dtos.PublisherCreationDto;
import com.simplenewsaggregator.simplenewsaggregator.models.Publisher;
import com.simplenewsaggregator.simplenewsaggregator.repositories.PublisherRepository;
import com.simplenewsaggregator.simplenewsaggregator.services.XMLUnmarshalService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RequiredArgsConstructor
@RestController
public class PublisherController {
    
    private final RestTemplate restTemplate;

    private final XMLUnmarshalService xmlUnmarshalService;

    private final PublisherRepository publisherRepository;
    

    @PostMapping("/publisher")
    public ResponseEntity addPublisher(@RequestBody PublisherCreationDto publisherCreationDto) throws RestClientException, JiBXException {
        String rss = restTemplate.getForObject(publisherCreationDto.getUrlString(), String.class);

        ChannelDto channelDto = xmlUnmarshalService.unmarshalRssDto(rss).getChannelDto();

        Publisher publisher = ChannelMapper.INSTANCE.channelDtoToPublisher(channelDto, publisherCreationDto.getUrlString());

        publisherRepository.save(publisher);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/publisher")
    public Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/publisher/{id}")
    public Publisher getPublisher(@PathVariable Long id) {
        return publisherRepository.findById(id).get();
    }
    
}