package com.project.habitasse.domain.offer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.offer.entities.request.FileRequest;
import com.project.habitasse.domain.offer.entities.request.OfferRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_offer")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class Offer extends SuperclassEntity implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "demand_id", nullable = false)
    private Demand demand;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "username_user")
    private String username;

    @Column(name = "user_contact")
    private String contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer", orphanRemoval = true)
    private List<File> files;

    @Column(name = "accepted")
    private boolean accepted = false;

    @Column(name = "deleted")
    private boolean deleted = false;

    public static Offer createOffer(OfferRequest offerRequest) {
        Offer offer = new Offer();
        offer.setFiles(new ArrayList<>());
        for (FileRequest fileRequest : offerRequest.getFiles()) {
            File file = File.createFile(fileRequest);
            file.setOffer(offer);
            offer.getFiles().add(file);
        }

        offer.setDemand(offerRequest.getDemand());
        offer.setText(offerRequest.getText());
        offer.setUserId(offerRequest.getUser().getId());
        offer.setUserEmail(offerRequest.getUser().getEmail());
        offer.setUsername(offerRequest.getUser().getUsernameForDto());
        offer.setContact(offerRequest.getContact());
        offer.setDeleted(false);

        return offer;
    }

    public static Offer updateOffer(Offer offer, OfferRequest offerRequest) {
        offer.setText(offerRequest.getText());
        offer.setDeleted(false);

        if (!offer.getFiles().isEmpty() && offerRequest.getFiles().isEmpty()) {
            offer.getFiles().clear();
            return offer;
        }
        if (offer.getFiles().size() > offerRequest.getFiles().size()) {
            Set<String> requestFileKeys = offerRequest.getFiles().stream()
                    .map(FileRequest::getKey)
                    .collect(Collectors.toSet());

            List<File> filesToRemove = offer.getFiles().stream()
                    .filter(file -> !requestFileKeys.contains(file.getKey()))
                    .toList();

            offer.getFiles().removeAll(filesToRemove);
            return offer;
        }
        if (offer.getFiles().isEmpty() && !offerRequest.getFiles().isEmpty()) {
            for (FileRequest fileRequest : offerRequest.getFiles()) {
                File file = File.createFile(fileRequest);
                file.setOffer(offer);
                offer.getFiles().add(file);
            }
            return offer;
        }
        if (!offer.getFiles().isEmpty() && !offerRequest.getFiles().isEmpty()) {
            if (haveSameFiles(offer.getFiles(), offerRequest.getFiles())) {
                return offer;
            } else {
                List<FileRequest> newFiles = removeDuplicateFiles(offer.getFiles(), offerRequest.getFiles());
                for (FileRequest newFile : newFiles) {
                    File file = File.createFile(newFile);
                    file.setOffer(offer);
                    offer.getFiles().add(file);
                }
                return offer;
            }
        }
        return offer;
    }

    private static boolean haveSameFiles(List<File> files1, List<FileRequest> files2) {
        Set<String> names1 = files1.stream()
                .map(File::getKey)
                .collect(Collectors.toSet());

        Set<String> names2 = files2.stream()
                .map(FileRequest::getKey)
                .collect(Collectors.toSet());

        return names1.equals(names2);
    }

    private static List<FileRequest> removeDuplicateFiles(List<File> offerFiles, List<FileRequest> requestFiles) {
        Set<String> fileKeys = offerFiles.stream()
                .map(File::getKey)
                .collect(Collectors.toSet());

        return requestFiles.stream()
                .filter(fileRequest -> !fileKeys.contains(fileRequest.getKey()))
                .collect(Collectors.toList());
    }

    public static void acceptedOffer(Offer offer) {
        offer.setAccepted(true);
    }

    public static void delete(Offer offer) {
        offer.setDeleted(true);
    }
}
