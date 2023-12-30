package com.product.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private UUID id;
    private Date createdAt;
    private Date lastUpdatedAt;
    @Enumerated(value = EnumType.ORDINAL)
    private Deleted isDeleted;
}
