package com.simplenewsaggregator.simplenewsaggregator.models;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Publisher {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String url;
    private String language;

    @OneToOne(targetEntity=PublisherConfiguration.class)
    PublisherConfiguration configuration;

    @OneToMany(targetEntity=Story.class)
    List<Story> stories;

}
