package com.simplenewsaggregator.simplenewsaggregator.dtos;

import java.util.ArrayList;
import java.util.List;
// lomboc à utiliser

public class ChannelDto {
    private String title;
    private String link;
    private String description;
    private String language;
    private String updatePeriod;
    private int updateFrequency;
    private ArrayList<ItemDto> items;


    public ChannelDto() {
    }



    public ChannelDto(String title, String link, String description, String language, String updatePeriod, int updateFrequency, ArrayList<ItemDto> items) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.updatePeriod = updatePeriod;
        this.updateFrequency = updateFrequency;
        this.items = items;
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

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public List<ItemDto> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<ItemDto> items) {
        this.items = items;
    }



    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", link='" + getLink() + "'" +
            ", description='" + getDescription() + "'" +
            ", language='" + getLanguage() + "'" +
            ", updatePeriod='" + getUpdatePeriod() + "'" +
            ", updateFrequency='" + getUpdateFrequency() + "'" +
            ", items='" + getItems() + "'" +
            "}";
    }


}
