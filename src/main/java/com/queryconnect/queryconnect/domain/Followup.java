package com.queryconnect.queryconnect.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "followup")
public class Followup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followupId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "enquiryId")
    private Enquiry enquiry;

    @Column(name = "doe")
    private Instant doe;

    @Column(name = "detail", length = 200)
    private String detail;

}