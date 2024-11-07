package com.simplenewsaggregator.simplenewsaggregator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.simplenewsaggregator.controllers.RSSController;

@SpringBootTest
public class RSSControllerTest {
    
    @Autowired
    private RSSController controller;

    @Test
    void shouldInitialise(){
        assertNotNull(controller);
    }

    
}
