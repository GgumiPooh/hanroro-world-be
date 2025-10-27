package com.ggumipooh.hanroroworld.be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
public class Goods extends BaseEntity {

    @Column
    private String name;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private List<Map<String, String>> metadata;
}
