package com.project.habitasse.domain.offer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.offer.entities.request.FileRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_files")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class File extends SuperclassEntity implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    @Column(name = "bucket", nullable = false)
    private String bucket;

    @Column(name = "file_key", nullable = false)
    private String key;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "status")
    private Integer status;

    @Column(name = "body")
    private String body;

    public static File createFile(FileRequest fileRequest) {
        return File.builder()
                .bucket(fileRequest.getBucket())
                .key(fileRequest.getKey())
                .location(fileRequest.getLocation())
                .status(fileRequest.getStatus())
                .body(fileRequest.getBody())

                .build();
    }
}
