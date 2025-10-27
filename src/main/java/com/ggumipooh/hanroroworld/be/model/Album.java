package com.ggumipooh.hanroroworld.be.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album extends BaseEntity {

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private String title;

    @Column
    private Instant published_at;

    @OneToMany(mappedBy = "song_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs = new ArrayList<>();
}

