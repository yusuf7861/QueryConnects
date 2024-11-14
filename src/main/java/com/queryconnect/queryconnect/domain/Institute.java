package com.queryconnect.queryconnect.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "institute")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institute_id", nullable = false)
    private Long instituteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private Contact contact;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "doe")
    private Instant doe;

    @OneToMany(mappedBy = "institute")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "institute")
    private List<Enquiry> enquiries = new ArrayList<>();

}