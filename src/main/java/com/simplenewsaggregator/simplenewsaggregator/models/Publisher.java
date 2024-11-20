package com.simplenewsaggregator.simplenewsaggregator.models;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToOne(targetEntity=PublisherConfiguration.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "publisher")
    PublisherConfiguration configuration;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "publisher")
    List<Story> stories;

}
