package com.simplenewsaggregator.simplenewsaggregator.models;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PublisherConfiguration {
    @Id @GeneratedValue
    private Long id;
    private String RSSUrl;
    private String updatePeriod;
    private int updateFrequency;

    @OneToOne
    private Publisher publisher;


    public PublisherConfiguration() {
    }

    public PublisherConfiguration(String RSSUrl, String updatePeriod, int updateFrequency) {
        this.RSSUrl = RSSUrl;
        this.updatePeriod = updatePeriod;
        this.updateFrequency = updateFrequency;
    }

    public String getRSSUrl() {
        return this.RSSUrl;
    }

    public void setRSSUrl(String RSSUrl) {
        this.RSSUrl = RSSUrl;
    }

    public String getUpdatePeriod() {
        return this.updatePeriod;
    }

    public void setUpdatePeriod(String updatePeriod) {
        this.updatePeriod = updatePeriod;
    }

    public int getUpdateFrequency() {
        return this.updateFrequency;
    }

    public void setUpdateFrequency(int updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public PublisherConfiguration RSSUrl(String RSSUrl) {
        setRSSUrl(RSSUrl);
        return this;
    }

    public PublisherConfiguration updatePeriod(String updatePeriod) {
        setUpdatePeriod(updatePeriod);
        return this;
    }

    public PublisherConfiguration updateFrequency(int updateFrequency) {
        setUpdateFrequency(updateFrequency);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PublisherConfiguration)) {
            return false;
        }
        PublisherConfiguration publisherConfiguration = (PublisherConfiguration) o;
        return Objects.equals(RSSUrl, publisherConfiguration.RSSUrl) && Objects.equals(updatePeriod, publisherConfiguration.updatePeriod) && Objects.equals(updateFrequency, publisherConfiguration.updateFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RSSUrl, updatePeriod, updateFrequency);
    }

    @Override
    public String toString() {
        return "{" +
            " RSSUrl='" + getRSSUrl() + "'" +
            ", updatePeriod='" + getUpdatePeriod() + "'" +
            ", updateFrequency='" + getUpdateFrequency() + "'" +
            "}";
    }
    
}
