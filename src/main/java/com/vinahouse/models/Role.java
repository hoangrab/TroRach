package com.vinahouse.models;

import com.vinahouse.models.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "roles")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private ERole name;

    @Column(length = 128)
    private String description;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Role(ERole eRole) {
        this.name = eRole;
    }

    public Role(int id) {
        this.id = id;
    }


    public Role(String name, String description) {
        this.name = ERole.valueOf(name);
        this.description = description;
    }
}
