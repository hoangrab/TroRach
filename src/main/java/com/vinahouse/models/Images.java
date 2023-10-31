package com.vinahouse.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
public class Images {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 128)
    private String url;

    @JsonIgnore
    @ManyToMany(mappedBy = "lImages")
    private List<Hostel> Lhostels = new ArrayList<>();

    @ManyToMany(mappedBy = "lImage")
    private List<Post> LPost = new ArrayList<>();

    public Images(String url) {
        this.url = url;
    }
    public Images(int id) {this.id = id;}
}
