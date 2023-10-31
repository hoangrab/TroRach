package com.vinahouse.DTO;

import java.util.List;

public class PostDTO {
    private int id;
    private String title;
    private long price;
    private int acreage;
    private String address;
    private String description;
    private String thumbnail;
    private String Day;
    private String type;
    private String kind;
    private String juridical;
    private int iduser;
    private List<String> images;

    public PostDTO(int id, String title, long price, int acreage, String address, String description,
                   String thumbnail, String day, String type, String kind, String juridical, int iduser, List<String> images) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.acreage = acreage;
        this.address = address;
        this.description = description;
        this.thumbnail = thumbnail;
        Day = day;
        this.type = type;
        this.kind = kind;
        this.juridical = juridical;
        this.iduser = iduser;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getJuridical() {
        return juridical;
    }

    public void setJuridical(String juridical) {
        this.juridical = juridical;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
