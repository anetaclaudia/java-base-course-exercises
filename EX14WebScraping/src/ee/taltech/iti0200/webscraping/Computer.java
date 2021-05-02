package ee.taltech.iti0200.webscraping;

import com.google.gson.annotations.SerializedName;

public class Computer {
    @SerializedName("Title")
    String title;
    @SerializedName("Price")
    String price;
    @SerializedName("Picture href")
    String pictureHref;
    @SerializedName("Picture src")
    String pictureSrc;

    public String getPictureSrc() {
        return pictureSrc;
    }

    public void setPictureSrc(String pictureSrc) {
        this.pictureSrc = pictureSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }
}
