package com.ggumipooh.hanroroworld.be.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true)
    private String nickname;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserFavoriteSong favoriteSong;

    @Column
    private String provider;

    @Column
    private String providerId;
}
