package com.simplenewsaggregator.simplenewsaggregator.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Story {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String url;
    private String description;

    @ManyToOne
    private Publisher publiser;

}
