package com.simplenewsaggregator.simplenewsaggregator.models;
import java.util.Objects;

public class PublisherConfiguration {
    private String RSSUrl;
    private String updatePeriod;
    private String updateFrequency;


    public PublisherConfiguration() {
    }

    public PublisherConfiguration(String RSSUrl, String updatePeriod, String updateFrequency) {
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

    public String getUpdateFrequency() {
        return this.updateFrequency;
    }

    public void setUpdateFrequency(String updateFrequency) {
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

    public PublisherConfiguration updateFrequency(String updateFrequency) {
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
