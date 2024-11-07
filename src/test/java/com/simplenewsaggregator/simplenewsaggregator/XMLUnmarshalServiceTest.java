package com.simplenewsaggregator.simplenewsaggregator;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simplenewsaggregator.simplenewsaggregator.services.XMLUnmarshalService;

@SpringBootTest
public class XMLUnmarshalServiceTest {
    
    @Autowired
    private XMLUnmarshalService xmlUnmarshalService;

    @Test
    void shouldUnmarshalStrictStructureWoNameSpace() throws Exception{
        File file = new File("src/main/resources/static/rss/feed.xml");
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(this.xmlUnmarshalService.unmarshalChannelDto(content));
    }
}
