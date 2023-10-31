package com.vinahouse.DTO;

import java.util.List;

public class HostelDTO {
    private int id;
    private String title;
    private String description;
    private int acreage;
    private int rating;
    private String address;
    private String thumbnail;
    private List<String> images;
    private int iduser;
    private int room;
    private int emptyroom;

    public HostelDTO(int id, String title, String description, int acreage, int rating,
                     String address, String thumbnail, List<String> images, int iduser, int room, int emptyroom) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.acreage = acreage;
        this.rating = rating;
        this.address = address;
        this.thumbnail = thumbnail;
        this.images = images;
        this.iduser = iduser;
        this.room = room;
        this.emptyroom = emptyroom;
    }

    public HostelDTO() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getEmptyroom() {
        return emptyroom;
    }

    public void setEmptyroom(int emptyroom) {
        this.emptyroom = emptyroom;
    }
}
