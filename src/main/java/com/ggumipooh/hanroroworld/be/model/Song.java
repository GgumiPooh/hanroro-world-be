package com.ggumipooh.hanroroworld.be.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity {

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private String title;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private String lyrics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album")
    private Album album;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserFavoriteSong> userFavorites = new ArrayList<>();

    @OneToMany(mappedBy = "song",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentSong> comments = new ArrayList<>();
}
