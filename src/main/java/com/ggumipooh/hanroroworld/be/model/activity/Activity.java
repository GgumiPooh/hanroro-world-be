package com.ggumipooh.hanroroworld.be.model.activity;

import com.ggumipooh.hanroroworld.be.model.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Entity
public class Activity extends BaseEntity {

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private String title;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "meta_datas", columnDefinition = "json")
    private List<Map<String, String>> metadata;

    @Column
    private Instant active_from;

    @Column
    private Instant active_to;
}
