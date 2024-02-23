package com.project.habitasse.domain.common;

import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class SuperclassEntity implements Serializable {

    private static final long serialVersionUID = 3270601256011818010L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    protected Integer id;

    @Column(unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @PrePersist
    private void setCreationDate() {
        this.creationDate = LocalDateTime.now();
    }

    public SuperclassEntity() {
    }

    public SuperclassEntity(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() == null ? super.hashCode() : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (obj.getClass().equals(getClass())) && obj.hashCode() == hashCode();
    }
}
