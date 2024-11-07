package com.simplenewsaggregator.simplenewsaggregator.services;

import java.io.StringReader;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.springframework.stereotype.Service;

import com.simplenewsaggregator.simplenewsaggregator.dtos.RssDto;

@Service
public class XMLUnmarshalService {
    public RssDto unmarshalRssDto(String rss) throws JiBXException {
        IBindingFactory factory = BindingDirectory.getFactory(RssDto.class);
        IUnmarshallingContext unmarshallingContext = factory.createUnmarshallingContext();

        return (RssDto) unmarshallingContext.unmarshalDocument(new StringReader(rss));
    }
}
