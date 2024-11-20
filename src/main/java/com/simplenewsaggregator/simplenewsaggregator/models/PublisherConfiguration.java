package com.simplenewsaggregator.simplenewsaggregator.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class PublisherConfiguration {
    @Id @GeneratedValue
    private Long id;
    private String rssUrl;
    private String updatePeriod;
    private int updateFrequency;

    @OneToOne(targetEntity=Publisher.class)
    @ToString.Exclude private Publisher publisher;
    
}
