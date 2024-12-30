package com.queryconnect.queryconnect.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "enquiry")
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enquiryId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contactId")
    private Contact contact;

    @Column(name = "doe")
    private Instant doe;

    @Column(name = "nextCallDate")
    private LocalDate nextCallDate;

    @Column(name = "remark", length = 400)
    private String remark;

    @Column(name = "committedFees")
    private Double committedFees;

    @Column(name = "lastUpdate")
    private Instant lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "instituteId")
    private Institute institute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enquirySourceId")
    private EnquirySource enquirySource;

    @OneToMany(mappedBy = "enquiry")
    private List<Enquirycourse> enquirycourses = new ArrayList<>();

    @OneToMany(mappedBy = "enquiry")
    private List<Followup> followups = new ArrayList<>();

}