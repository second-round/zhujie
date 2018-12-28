package com.example.homework.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserBean {
    @Id(autoincrement = true)
    private long id;
    private String detailUrl;
    private String images;
    private double price;
    private String subhead;
    private String title;
    @Generated(hash = 496723541)
    public UserBean(long id, String detailUrl, String images, double price,
            String subhead, String title) {
        this.id = id;
        this.detailUrl = detailUrl;
        this.images = images;
        this.price = price;
        this.subhead = subhead;
        this.title = title;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDetailUrl() {
        return this.detailUrl;
    }
    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
    public String getImages() {
        return this.images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getSubhead() {
        return this.subhead;
    }
    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
