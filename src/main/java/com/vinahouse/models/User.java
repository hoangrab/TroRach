package com.vinahouse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @Column(unique = true,length = 64)
    @NotBlank(message = "Tai khoan khong duoc null")
    private String gmail;

    @JsonIgnore
    @Column(length = 128)
    @NotBlank(message = "Mat khau khong duoc null nha con")
    private String password;

    @JsonIgnore
    @Column(length = 64, nullable = false)
    private String displayName;

    @JsonIgnore
    @Column(length = 20)
    private String phone;

    @JsonIgnore
    private Long money;

    @JsonIgnore
    @Column(length = 128)
    private String verifyCode;

    @JsonIgnore
    private boolean enabled;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String gmail,String password) {
        this.gmail = gmail;
        this.password = password;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
