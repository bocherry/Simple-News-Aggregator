package com.simplenewsaggregator.simplenewsaggregator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @ToString.Exclude private Publisher publisher;
    
}
