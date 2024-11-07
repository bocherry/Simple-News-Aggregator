package com.simplenewsaggregator.simplenewsaggregator.models;
import java.util.Objects;

public class Publisher {
    private String title;
    private String description;
    private String url;
    private String language;

    public Publisher() {
    }

    public Publisher(String title, String description, String url, String language) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Publisher title(String title) {
        setTitle(title);
        return this;
    }

    public Publisher description(String description) {
        setDescription(description);
        return this;
    }

    public Publisher url(String url) {
        setUrl(url);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Publisher)) {
            return false;
        }
        Publisher publisher = (Publisher) o;
        return Objects.equals(title, publisher.title) && Objects.equals(description, publisher.description) && Objects.equals(url, publisher.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, url);
    }


    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", url='" + getUrl() + "'" +
            ", language='" + getLanguage() + "'" +
            "}";
    }


}
