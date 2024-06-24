package com.thein3rovert.shotLensApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
//@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public abstract class Auditable {
    private Long id;
    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString(); // Id will be used to identity resources.

    @NotNull
    private Long createdBy; //who created the entity and who updated the entity.
    private Long updatedBy;
    private LocalDateTime createdAt; //Time an entity was created and updated.
    private LocalDateTime updatedAt;
}
