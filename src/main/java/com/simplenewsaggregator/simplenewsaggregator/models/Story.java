package com.simplenewsaggregator.simplenewsaggregator.models;
import java.util.Objects;

public class Story {
    private String title;
    private String url;
    private String description;

    public Story() {
    }

    public Story(String title, String url, String description) {
        this.title = title;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Story title(String title) {
        setTitle(title);
        return this;
    }

    public Story url(String url) {
        setUrl(url);
        return this;
    }

    public Story description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Story)) {
            return false;
        }
        Story story = (Story) o;
        return Objects.equals(title, story.title) && Objects.equals(url, story.url) && Objects.equals(description, story.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url, description);
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", url='" + getUrl() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }


}
