package com.simplenewsaggregator.simplenewsaggregator.dtos;

public class ItemDto {
    private String title;
    private String link;
    private String description;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", link='" + getLink() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

}
