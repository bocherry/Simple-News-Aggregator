package com.simplenewsaggregator.simplenewsaggregator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;
import java.io.IOException;
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
    void shouldUnmarshalStrictStructureWoNameSpace() throws IOException{
        File file = new File("src/main/resources/static/rss/strictFeedWoNamespace.xml");
        String content = new String(Files.readAllBytes(file.toPath()));
        assertDoesNotThrow(() -> this.xmlUnmarshalService.unmarshalRssDto(content));
    }

    @Test
    void shouldUnmarshalDocumentWithUnnecessaryFields() throws IOException{
        File file = new File("src/main/resources/static/rss/feedUnecWoNamespace.xml");
        String content = new String(Files.readAllBytes(file.toPath()));
        assertDoesNotThrow(() -> this.xmlUnmarshalService.unmarshalRssDto(content));
    }

    @Test
    void shouldUnMarshalDocumentWithNameSpace() throws IOException{
        File file = new File("src/main/resources/static/rss/feedNamespace.xml");
        String content = new String(Files.readAllBytes(file.toPath()));
        assertDoesNotThrow(() -> this.xmlUnmarshalService.unmarshalRssDto(content));
    }

    @Test
    void shouldUnmarshalSampleRss() throws IOException{
        File file = new File("src/main/resources/static/rss/feedSampleCpc.xml");
        String content = new String(Files.readAllBytes(file.toPath()));
        assertDoesNotThrow(() -> this.xmlUnmarshalService.unmarshalRssDto(content));
    }
}
