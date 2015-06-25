package com.example.rakatak.liquidrakatak.datalogic.article;

import java.io.Serializable;

/**
 * Created by robins on 25.06.15.
 */
public class Article implements Serializable {

    public int imageId;
    public String title;
    public String platform;
    public Boolean availability;
    public double price;

    public Article(int imageId, String title, String platform, Boolean availability, double price) {
        this.imageId = imageId;
        this.title = title;
        this.platform = platform;
        this.availability = availability;
        this.price = price;

    }

    public Boolean getAvailability(){
        return this.availability;
    }

    public int getImageId() {
        return this.imageId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPlatform() {
        return this.platform;
    }

    public double getPrice() {
        return price;
    }
}
