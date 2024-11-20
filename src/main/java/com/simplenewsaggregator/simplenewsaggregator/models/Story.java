package com.simplenewsaggregator.simplenewsaggregator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
    @Column(columnDefinition="TEXT")
    private String description;

    @ManyToOne(targetEntity=Publisher.class)
    @JsonIgnore
    private Publisher publisher;

}
