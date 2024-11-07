package com.simplenewsaggregator.simplenewsaggregator.controllers;

import org.jibx.runtime.JiBXException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.simplenewsaggregator.simplenewsaggregator.services.XMLUnmarshalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RSSController {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private XMLUnmarshalService xmlUnmarshalService;
    

    @GetMapping("/rss")
    public String addRSS(@RequestParam(value="url") String param) throws RestClientException, JiBXException {
        String rss = restTemplate.getForObject(param, String.class);
        return xmlUnmarshalService.unmarshalRssDto(rss).toString();
    }
    
}
