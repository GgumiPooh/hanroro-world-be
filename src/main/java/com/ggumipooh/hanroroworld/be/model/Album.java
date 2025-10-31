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
    private List<LanguageData> title;

    @Column
    private Instant publishedAt;

    @Column
    private List<LanguageData> description;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private List<Metadata> metadata;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs = new ArrayList<>();
}

