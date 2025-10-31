package com.ggumipooh.hanroroworld.be.model.activity;

import com.ggumipooh.hanroroworld.be.model.BaseEntity;
import com.ggumipooh.hanroroworld.be.model.LanguageData;
import com.ggumipooh.hanroroworld.be.model.Metadata;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;

@Entity
@Setter
@Getter
public class Activity extends BaseEntity {

    @Column(unique = true)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<LanguageData> title;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private LanguageData description;

    @Column
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column
    private List<Metadata> metaData;

    @Column
    private Instant activeFrom;

    @Column
    private Instant activeTo;
}
