package com.thein3rovert.shotLensApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thein3rovert.shotLensApp.domain.RequestContext;
import com.thein3rovert.shotLensApp.exception.CustomApiException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.NotFound;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;


import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true) // Ignore properties during Json Serlization
public abstract class Auditable {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")

    @Column(name = "id", updatable = false)
    private Long id;
    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString(); // Id will be used to identity resources.

    @NotNull
    private Long createdBy; //who created the entity and who updated the entity.
    @NotNull
    private Long updatedBy;

    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt; //Time an entity was created and updated.
    @Column(name = "updated_at", nullable = false)
    @CreatedDate
    private LocalDateTime updatedAt;

    //Todo: 1. Create PrePersist and PreUodate, add annotations to Id;

    @PrePersist
    public void beforePersist() {
        var userId = RequestContext.getUserId();
        if (userId == null) {
            throw new CustomApiException("Cannot persist this entity without it's user ID in the request Context for this thread");
        }
        setCreatedAt(LocalDateTime.now());
        setCreatedBy(userId);
        setUpdatedBy(userId);
        setUpdatedAt(LocalDateTime.now());
    }

    @PostPersist
    public void beforeUpdate() {
        var userId = RequestContext.getUserId();
        if (userId == null) {
            throw new CustomApiException("Cannot update this entity without it's user ID in the request Context for this thread");}
            setUpdatedAt(LocalDateTime.now());
            setUpdatedBy(userId);#
    }
}

