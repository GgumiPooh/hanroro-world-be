package com.ggumipooh.hanroroworld.be.model;

import jakarta.persistence.*;

@Entity
public class UserFavoriteSong extends BaseEntity{

    @OneToOne
    @MapsId  // user_id를 primary key로 재사용
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id", nullable = false)
    private Song song;

}
