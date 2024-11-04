package com.simplenewsaggregator.simplenewsaggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RSSController {
    
    @Autowired
    private RestTemplate restTemplate;
    

    @GetMapping("/rss")
    public String addRSS(@RequestParam(value="url") String param) {
        String rss = restTemplate.getForObject(param, String.class);
        return rss;
    }
    
}
