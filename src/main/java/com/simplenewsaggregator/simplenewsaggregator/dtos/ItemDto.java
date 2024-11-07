package com.simplenewsaggregator.simplenewsaggregator.dtos;

public class ItemDto {
    private String title;
    private String link;

    public ItemDto() {
    }
    private String description;

    public ItemDto(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

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
