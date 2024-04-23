package com.project.habitasse.domain.uploadFiles;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3Service {
    @Value("${aws.bucket-name}")
    private String bucketName;

    private final AmazonS3 amazonS3;

    public S3Service(@Value("${aws.access-key}") String accessKey,
                     @Value("${aws.secret-key}") String secretKey,
                     @Value("${aws.region}") String region) {
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey, secretKey)))
                .withRegion(region)
                .build();
    }

    public void uploadFile(MultipartFile file) {
        try {
            amazonS3.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
