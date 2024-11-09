package com.simplenewsaggregator.simplenewsaggregator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class PublisherConfiguration {
    @Id @GeneratedValue
    private Long id;
    private String RSSUrl;
    private String updatePeriod;
    private int updateFrequency;

    @OneToOne(targetEntity=Publisher.class)
    private Publisher publisher;
    
}
