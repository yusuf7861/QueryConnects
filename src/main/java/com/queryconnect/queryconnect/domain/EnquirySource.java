package com.queryconnect.queryconnect.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "enquirySource")
public class EnquirySource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long enquirySourceId;

    @Column(name = "name", length = 100)
    private String name;

//    @OneToMany(mappedBy = "enquirySource")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Enquiry> enquiries = new ArrayList<>();
}