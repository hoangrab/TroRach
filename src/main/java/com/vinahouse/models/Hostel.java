package com.vinahouse.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hostel")
@Data
@NoArgsConstructor
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private long price;
    private int acreage;
    private int rating;
    private String address;
    private String thumbnail;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hostel_images",
            joinColumns = @JoinColumn(name = "hostel_id"),
            inverseJoinColumns = @JoinColumn(name = "images_id")
    )
    private List<Images> lImages = new ArrayList<>();

    @OneToOne
    private User user;
    private int room;
    private int emptyroom;

    public Hostel(String title, String description, long price, int acreage, int rating, String address, String thumbnail, List<Images> lImages, int room, int emptyroom,User u) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.acreage = acreage;
        this.rating = rating;
        this.address = address;
        this.thumbnail = thumbnail;
        this.lImages = lImages;
        this.room = room;
        this.emptyroom = emptyroom;
        this.user = u;
    }
}
