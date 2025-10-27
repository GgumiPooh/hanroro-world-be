package com.ggumipooh.hanroroworld.be.model;

import jakarta.persistence.*;

@Entity
public class CommentSong extends BaseEntity {

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
