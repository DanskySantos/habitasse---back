package com.project.habitasse.domain.offer.entities.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileRequest {

    private String bucket;
    private String key;
    private String location;
    private Integer status;
    private String body;
}
